package com.opencodely.codelyhexagonal.ascent.domain;

import com.opencodely.codelyhexagonal.shared.domain.EventStore;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import com.opencodely.codelyhexagonal.shared.domain.event.AscentAddedDomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class Ascent implements EventStore, Validatable {
  @Setter(AccessLevel.NONE)
  @Getter(AccessLevel.NONE)
  private final List<DomainEvent> events = new ArrayList<>();
  @NotNull
  private AscentId id;
  @NotNull
  private AscentClimber climber;
  @NotNull
  private AscentRoute route;
  private Grade proposedGrade;
  private AscensionDate ascensionDate;

  public static Ascent createAscent(final UUID ascentId, final UUID climberId, final UUID routeId,
                                    final Grade proposedGrade, final LocalDate ascensionDate) {
    final Ascent ascent = new Ascent();
    ascent.id = new AscentId(ascentId);
    ascent.climber = new AscentClimber(climberId);
    ascent.route = new AscentRoute(routeId);
    ascent.proposedGrade = proposedGrade;
    ascent.ascensionDate = new AscensionDate(ascensionDate);
    ascent.recordAscentCreation();
    return ascent;
  }

  private void recordAscentCreation() {
    recordEvent(AscentAddedDomainEvent.from(this));
  }

  @Override
  public List<DomainEvent> pullEvents() {
    return Collections.unmodifiableList(events);
  }

  @Override
  public void recordEvent(final DomainEvent event) {
    events.add(event);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ascent ascent = (Ascent) o;
    return Objects.equals(id, ascent.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
