package com.opencodely.codelyhexagonal.ascent.domain;

import com.opencodely.codelyhexagonal.shared.domain.Grade;
import com.opencodely.codelyhexagonal.shared.domain.event.AscentAddedDomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.EventStore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class Ascent implements EventStore {
    private Long id;
    private AscentClimber climber;
    private AscentRoute route;
    private Grade proposedGrade;
    private AscensionDate ascensionDate;
    @Getter(AccessLevel.NONE)
    private final List<DomainEvent> events = new ArrayList<>();

    public static Ascent createDraft(long climberId, long routeId, Grade proposedGrade, LocalDate ascensionDate) {
        Ascent ascent = new Ascent();
        ascent.climber = new AscentClimber(climberId, null);
        ascent.route = new AscentRoute(routeId, null);
        ascent.proposedGrade = proposedGrade;
        ascent.ascensionDate = new AscensionDate(ascensionDate);
        return ascent;
    }

    public static Ascent createDraft(long climberId, long routeId, Grade proposedGrade) {
        return createDraft(climberId, routeId, proposedGrade, LocalDate.now());
    }

    public void recordNewAscent(long id) {
        this.id = id;
        recordEvent(AscentAddedDomainEvent.from(this));
    }

    @Override
    public List<DomainEvent> pullEvents() {
        return Collections.unmodifiableList(events);
    }

    @Override
    public void recordEvent(DomainEvent event) {
        this.events.add(event);
    }
}
