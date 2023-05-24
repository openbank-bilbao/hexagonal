package com.opencodely.codelyhexagonal.climber.domain;

import com.opencodely.codelyhexagonal.shared.domain.EventStore;
import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import com.opencodely.codelyhexagonal.shared.domain.event.ClimberCreatedDomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

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
  @NotBlank
  private String name;
  @NotNull
  private EmailAddress email;

  public static Climber createClimber(final UUID id, String name, final String email) {
    Climber climber = new Climber(new ClimberId(id), name, new EmailAddress(email));
    climber.validate();
    climber.recordClimberCreation();
    return climber;
  }

  private void recordClimberCreation() {
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

