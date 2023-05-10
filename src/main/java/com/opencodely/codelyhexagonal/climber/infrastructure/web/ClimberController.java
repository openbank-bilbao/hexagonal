package com.opencodely.codelyhexagonal.climber.infrastructure.web;

import com.opencodely.codelyhexagonal.climber.application.CreateClimberApplicationService;
import com.opencodely.codelyhexagonal.climber.domain.EmailAddress;
import com.opencodely.codelyhexagonal.shared.domain.IdProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ClimberController {
  private final CreateClimberApplicationService createClimberService;
  private final IdProvider<UUID> idProvider;

  @PostMapping(ClimberUrl.BASE_V1)
  @ResponseStatus(HttpStatus.CREATED)
  public ClimberCreatedResponse create(@RequestBody @Valid ClimberCreateRequest climberCreateRequest) {
    final var uuid = idProvider.provide();
    createClimberService.create(uuid, climberCreateRequest.name(), climberCreateRequest.email());
    return ClimberCreatedResponse.from(ClimberUrl.BASE_V1, uuid);
  }
}
