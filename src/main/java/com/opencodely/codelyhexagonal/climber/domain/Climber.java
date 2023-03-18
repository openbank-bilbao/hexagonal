package com.opencodely.codelyhexagonal.climber.domain;

import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import com.opencodely.codelyhexagonal.shared.domain.event.ClimberCreatedDomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.EventStore;
import jakarta.validation.constraints.NotBlank;
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
public class Climber implements EventStore, Validatable {
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotBlank
    private String name;
    private EmailAddress email;
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private final List<DomainEvent> events = new ArrayList<>();

    public static Climber draftClimber(final String name, final EmailAddress email) {
        Climber climber = new Climber(null, name, email);
        climber.validate();
        return climber;
    }

    public void recordClimberCreationEvent(long id) {
        this.id = id;
        recordEvent(ClimberCreatedDomainEvent.from(this));
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
        Climber climber = (Climber) o;
        return id.equals(climber.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

