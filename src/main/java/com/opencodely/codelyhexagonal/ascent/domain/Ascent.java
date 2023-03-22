package com.opencodely.codelyhexagonal.ascent.domain;

import com.opencodely.codelyhexagonal.shared.domain.EventStore;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import com.opencodely.codelyhexagonal.shared.domain.event.AscentAddedDomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class Ascent implements EventStore {

  @Getter(AccessLevel.NONE)
  private final List<DomainEvent> events = new ArrayList<>();
  @NotNull
  @Valid
  private AscentId ascentId;
  private AscentClimber climber;
  private AscentRoute route;
  private Grade proposedGrade;
  private AscensionDate ascensionDate;

  public static Ascent createDraft(
      final AscentId ascentId,
      final long climberId,
      final long routeId,
      final Grade proposedGrade,
      final LocalDate ascensionDate) {
    final Ascent ascent = new Ascent();
    ascent.ascentId = ascentId;
    ascent.climber = new AscentClimber(climberId, null);
    ascent.route = new AscentRoute(routeId, null);
    ascent.proposedGrade = proposedGrade;
    ascent.ascensionDate = new AscensionDate(ascensionDate);
    return ascent;
  }

  public static Ascent createDraft(
      final AscentId ascentId,
      final long climberId,
      final long routeId,
      final Grade proposedGrade) {
    return createDraft(ascentId, climberId, routeId, proposedGrade, LocalDate.now());
  }

  public void recordNewAscent() {
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
}
