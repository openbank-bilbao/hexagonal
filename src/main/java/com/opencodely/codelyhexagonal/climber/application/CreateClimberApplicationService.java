package com.opencodely.codelyhexagonal.climber.application;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.climber.domain.ClimberRepository;
import com.opencodely.codelyhexagonal.shared.application.UseCase;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateClimberApplicationService {

  private final ClimberRepository climberRepository;
  private final DomainEventPublisher eventPublisher;

  public void create(final UUID id, final String name, final String email) {
    final Climber climber = Climber.createClimber(id, name, email);
    climberRepository.save(climber);
    eventPublisher.publish(climber.pullEvents());
  }
}
