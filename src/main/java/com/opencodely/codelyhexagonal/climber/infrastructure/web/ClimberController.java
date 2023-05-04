package com.opencodely.codelyhexagonal.climber.infrastructure.web;

import com.opencodely.codelyhexagonal.climber.aplication.CreateClimberApplicationService;
import com.opencodely.codelyhexagonal.climber.domain.EmailAddress;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClimberController {
  private final CreateClimberApplicationService createClimberService;

  @PostMapping(ClimberUrl.BASE_V1)
  @ResponseStatus(HttpStatus.CREATED)
  public ClimberCreatedResponse create(@RequestBody @Valid ClimberCreateRequest climberCreateRequest) {
    Long id = createClimberService.create(climberCreateRequest.name(), new EmailAddress(climberCreateRequest.email()));
    return ClimberCreatedResponse.from(ClimberUrl.BASE_V1, id);
  }
}
