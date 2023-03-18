package com.opencodely.codelyhexagonal.shared.domain.event;

import com.opencodely.codelyhexagonal.ascent.domain.Ascent;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public final class AscentAddedDomainEvent extends DomainEvent {

    private Data data;

    public AscentAddedDomainEvent(UUID id, Instant creationTimestamp, Data data) {
        super(id, creationTimestamp);
        this.data = data;
    }

    public static AscentAddedDomainEvent from(Ascent ascent) {
        return new AscentAddedDomainEvent(
            UUID.randomUUID(),
            Instant.now(), new Data(ascent.getId(), ascent.getAscensionDate().date(), ascent.getClimber().id(),
            ascent.getRoute().id(), ascent.getProposedGrade()));
    }

        public record Data(long id, LocalDate ascensionDate, long climberId, long routeId, Grade proposedGrade) {
    }
}
