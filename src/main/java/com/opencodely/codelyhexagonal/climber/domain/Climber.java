package com.opencodely.codelyhexagonal.climber.domain;

import com.opencodely.codelyhexagonal.shared.domain.EventStore;
import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import com.opencodely.codelyhexagonal.shared.domain.event.ClimberCreatedDomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Climber implements EventStore, Validatable {

  @Setter(AccessLevel.NONE)
  @Getter(AccessLevel.NONE)
  private final List<DomainEvent> events = new ArrayList<>();
  @Setter(AccessLevel.NONE)
  @NotNull
  private ClimberId id;
  @NotNull
  private ClimberName name;
  @NotNull
  private EmailAddress email;

  public static Climber createClimber(final UUID id, final String name, final String email) {
    final Climber climber = new Climber(new ClimberId(id), new ClimberName(name),
      new EmailAddress(email));
    climber.validate();
    climber.recordClimberCreation();
    return climber;
  }

  private void recordClimberCreation() {
    recordEvent(ClimberCreatedDomainEvent.from(this));
  }

  @Override
  public void recordEvent(final DomainEvent event) {
    this.events.add(event);
  }

  @Override
  public List<DomainEvent> pullEvents() {
    return Collections.unmodifiableList(events);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Climber climber = (Climber) o;
    return id.equals(climber.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

