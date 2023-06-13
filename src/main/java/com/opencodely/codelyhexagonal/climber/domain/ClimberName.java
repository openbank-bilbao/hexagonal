package com.opencodely.codelyhexagonal.climber.domain;

import jakarta.validation.constraints.NotEmpty;

public class ClimberName extends ValueObject<String> {

  public ClimberName(@NotEmpty final String value) {
    super(value);
  }

}
