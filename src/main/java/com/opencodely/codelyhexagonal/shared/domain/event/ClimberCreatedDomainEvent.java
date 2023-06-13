package com.opencodely.codelyhexagonal.shared.domain.event;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import java.time.Instant;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public final class ClimberCreatedDomainEvent extends DomainEvent {

  private Data data;

  public ClimberCreatedDomainEvent(
    final UUID id,
    final Instant creationTimestamp,
    final Data data
  ) {
    super(id, creationTimestamp);
    this.data = data;
  }

  public static ClimberCreatedDomainEvent from(final Climber climber) {
    return new ClimberCreatedDomainEvent(
      UUID.randomUUID(),
      Instant.now(),
      new Data(climber.getId().id(), climber.getName().getValue())
    );
  }


  public record Data(UUID id, String climberName) {

  }
}
