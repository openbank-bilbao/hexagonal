package com.opencodely.codelyhexagonal.climber.infrastructure.web;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClimberCreatedResponseObjectMother {

  public static ClimberCreatedResponse with(final UUID uuid) {
    return new ClimberCreatedResponse(String.format("/api/v1/climber/%s", uuid));
  }
}
