package com.opencodely.codelyhexagonal.ascent.application;

import com.opencodely.codelyhexagonal.ascent.domain.*;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import com.opencodely.codelyhexagonal.shared.domain.event.AscentAddedDomainEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith({MockitoExtension.class})
class AddAscentTest {

  @Mock
  private AscentRepository ascentRepository;
  @Mock
  private DomainEventPublisher domainEventPublisher;
  @Captor
  private ArgumentCaptor<Ascent> ascentCaptor;
  @Captor
  private ArgumentCaptor<List<AscentAddedDomainEvent>> eventsCaptor;
  @InjectMocks
  private AddAscentApplicationService service;

  @Test
  void should_save_on_ascent_creation() {
    //given
    UUID ascentId = UUID.randomUUID();
    UUID climberId = UUID.randomUUID();
    UUID routeId = UUID.randomUUID();
    LocalDate ascentDate = LocalDate.now();

    //when
    service.addAscent(ascentId, climberId, routeId, Grade.GRADE_6B, ascentDate);

    //then
    verify(ascentRepository, times(1)).save(ascentCaptor.capture());
    assertThat(ascentCaptor.getValue())
      .returns(new AscentId(ascentId), Ascent::getId)
      .returns(new AscentRoute(routeId), Ascent::getRoute)
      .returns(new AscentClimber(climberId), Ascent::getClimber)
      .returns(Grade.GRADE_6B, Ascent::getProposedGrade)
      .returns(new AscensionDate(ascentDate), Ascent::getAscensionDate);
  }

  @Test
  void should_publish_event_on_ascent_creation() {
    //given
    UUID ascentId = UUID.randomUUID();
    UUID climberId = UUID.randomUUID();
    UUID routeId = UUID.randomUUID();
    LocalDate ascentDate = LocalDate.now();

    //when
    service.addAscent(ascentId, climberId, routeId, Grade.GRADE_6B, ascentDate);

    //then
    verify(domainEventPublisher, times(1)).publish(eventsCaptor.capture());
    List<AscentAddedDomainEvent> events = eventsCaptor.getValue();
    assertThat(events.get(0).getData())
      .returns(ascentId, AscentAddedDomainEvent.Data::id)
      .returns(routeId, AscentAddedDomainEvent.Data::routeId)
      .returns(climberId, AscentAddedDomainEvent.Data::climberId);

  }

  @Test
  void should_throw_on_future_ascent_date() {
    //given
    LocalDate ascentDate = LocalDate.now().plusDays(1);

    //when
    Throwable throwable = catchThrowable(() -> service.addAscent(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), Grade.GRADE_6B, ascentDate));

    //then
    assertThat(throwable).isNotNull();
  }
}
