package com.opencodely.codelyhexagonal.shared.domain.event;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.shared.domain.event.ClimberCreatedDomainEvent.Data;
import java.time.Instant;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClimberCreatedDomainEventObjectMother {

  public static ClimberCreatedDomainEvent from(final Climber climberExpected) {
    return new ClimberCreatedDomainEvent(
      UUID.randomUUID(),
      Instant.now(),
      new Data(climberExpected.getId().id(), climberExpected.getName().value())
    );
  }
}
