package com.opencodely.codelyhexagonal.climber.aplication;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.climber.domain.ClimberRepository;
import com.opencodely.codelyhexagonal.climber.domain.EmailAddress;
import com.opencodely.codelyhexagonal.shared.application.UseCase;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateClimberApplicationService {

  private final ClimberRepository climberRepository;
  private final DomainEventPublisher eventPublisher;

  public Long create(String name, EmailAddress email) {
    Climber climber = Climber.draftClimber(name, email);
    Long id = climberRepository.save(climber);
    climber.recordClimberCreationEvent(id);
    eventPublisher.publish(climber.pullEvents());
    return id;
  }
}
