package com.opencodely.codelyhexagonal.climber.infrastructure.web;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.opencodely.codelyhexagonal.climber.application.CreateClimberApplicationService;
import com.opencodely.codelyhexagonal.climber.domain.ClimberIdObjectMother;
import com.opencodely.codelyhexagonal.shared.domain.IdProvider;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClimberControllerTest {

  @Mock
  private CreateClimberApplicationService createClimberService;

  @Mock
  private IdProvider<UUID> idProvider;

  @InjectMocks
  private ClimberController subject;

  @Test
  void should_return_url() {
    //given
    final var uuid = ClimberIdObjectMother.random().id();
    final var request = ClimberCreateRequestObjectMother.random();
    when(idProvider.provide()).thenReturn(uuid);
    doNothing().when(createClimberService).create(uuid, request.name(), request.email());

    //when
    final var result = subject.create(request);

    //then
    final var expectedResponse = ClimberCreatedResponseObjectMother.with(uuid);
    Assertions.assertEquals(expectedResponse, result);
  }

}
