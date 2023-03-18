package com.opencodely.codelyhexagonal.shared.domain.event;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public final class ClimberCreatedDomainEvent extends DomainEvent {
    private Data data;

    public ClimberCreatedDomainEvent(UUID id, Instant creationTimestamp, Data data) {
        super(id, creationTimestamp);
        this.data = data;
    }

    public static ClimberCreatedDomainEvent from(Climber climber) {
        return new ClimberCreatedDomainEvent(
            UUID.randomUUID(),
            Instant.now(),
            new Data(climber.getId(), climber.getId()));
    }


    public record Data(long id, long climberId) {
    }
}
