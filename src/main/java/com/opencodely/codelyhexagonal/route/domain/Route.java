package com.opencodely.codelyhexagonal.route.domain;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.shared.domain.EventStore;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.RouteCreatedDomainEvent;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route implements EventStore, Validatable {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Crag crag;
    @NotNull
    private Grade baseGrade;
    private Grade consensusGrade;
    private int ascentNumber = 0;
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private final List<DomainEvent> events = new ArrayList<>();

    public static Route draftRoute(String name, String crag, Grade baseGrade) {
        Route route = new Route(null, name, new Crag(crag), baseGrade, baseGrade, 0);
        route.validate();
        return route;
    }

    public void addAscent() {
        ++ascentNumber;
    }

    public void recordRouteCreatedEvent(long id) {
        this.id = id;
        recordEvent(RouteCreatedDomainEvent.from(this));
    }

    @Override
    public void recordEvent(DomainEvent event) {
        this.events.add(event);
    }

    @Override
    public List<DomainEvent> pullEvents() {
        return Collections.unmodifiableList(events);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Route climber = (Route) o;
        return id.equals(climber.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
