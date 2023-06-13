package com.opencodely.codelyhexagonal.climber.domain;

import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ClimberName(@NotEmpty String value) implements Validatable {

  public ClimberName(@NotNull final String value) {
    this.value = value;
    validate();
  }

}
