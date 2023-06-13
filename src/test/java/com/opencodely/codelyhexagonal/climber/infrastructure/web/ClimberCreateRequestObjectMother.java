package com.opencodely.codelyhexagonal.climber.infrastructure.web;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClimberCreateRequestObjectMother {

  public static ClimberCreateRequest random() {
    return Instancio.create(ClimberCreateRequest.class);
  }
}
