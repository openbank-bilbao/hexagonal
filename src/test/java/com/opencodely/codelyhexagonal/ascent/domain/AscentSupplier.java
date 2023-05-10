package com.opencodely.codelyhexagonal.ascent.domain;

import com.opencodely.codelyhexagonal.shared.domain.Grade;

import java.time.LocalDate;
import java.util.UUID;

public class AscentSupplier {

  public static Ascent create(String climberId, String routeId) {
    AscentId ascentId = new AscentId(UUID.randomUUID());
    AscentClimber climber = new AscentClimber(UUID.fromString(climberId), "climber");
    AscentRoute route = new AscentRoute(UUID.fromString(routeId), "route");
    AscensionDate ascensionDate = new AscensionDate(LocalDate.of(2023, 1, 1));
    return new Ascent(ascentId, climber, route, Grade.GRADE_6B, ascensionDate);
  }

  public static AscentBuilder ascentBuilder() {
    return new AscentBuilder();
  }

  public static class AscentBuilder {
    private String climberId;
    private String routeId;

    private AscentBuilder() {}

    public AscentBuilder climberId(String id) {
      this.climberId = id;
      return this;
    }

    public AscentBuilder routeId(String id) {
      this.routeId = id;
      return this;
    }

    public Ascent build() {
      return AscentSupplier.create(climberId, routeId);
    }
  }

}
