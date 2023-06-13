package com.opencodely.codelyhexagonal.climber.application;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.climber.domain.ClimberObjectMother;
import com.opencodely.codelyhexagonal.climber.domain.ClimberRepository;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import com.opencodely.codelyhexagonal.shared.domain.event.ClimberCreatedDomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.ClimberCreatedDomainEventObjectMother;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateClimberApplicationServiceTest {

  @Mock
  private ClimberRepository climberRepository;

  @Mock
  private DomainEventPublisher eventPublisher;

  @InjectMocks
  private CreateClimberApplicationService subject;

  @Captor
  private ArgumentCaptor<Climber> climberArgumentCaptor;
  @Captor
  private ArgumentCaptor<List<ClimberCreatedDomainEvent>> eventsArgumentCaptor;

  @Test
  void should_create_a_climber() {
    //given
    final var climberExpected = ClimberObjectMother.random();
    final var id = climberExpected.getId().id();
    final var name = climberExpected.getName().getValue();
    final var email = climberExpected.getEmail().value();
    doNothing().when(climberRepository).save(climberExpected);

    //when
    subject.create(id, name, email);

    //then
    verify(climberRepository).save(climberArgumentCaptor.capture());
    final var climberCaptured = climberArgumentCaptor.getValue();
    Assertions.assertThat(climberExpected).isEqualTo(climberCaptured);
  }

  @Test
  void should_publish_event() {
    //given
    final var climberExpected = ClimberObjectMother.random();
    final var id = climberExpected.getId().id();
    final var name = climberExpected.getName().getValue();
    final var email = climberExpected.getEmail().value();
    doNothing().when(climberRepository).save(climberExpected);

    //when
    subject.create(id, name, email);

    //then
    verify(eventPublisher).publish(eventsArgumentCaptor.capture());
    final var capturedEvents = eventsArgumentCaptor.getValue();
    final var expectedEvent = ClimberCreatedDomainEventObjectMother.from(climberExpected);
    Assertions.assertThat(capturedEvents)
      .hasSize(1)
      .usingRecursiveComparison()
      .ignoringFields("id", "creationTimestamp")
      .isEqualTo(List.of(expectedEvent));

  }
}
