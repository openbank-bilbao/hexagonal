package com.opencodely.codelyhexagonal.climber.domain;

import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClimberId(@NotNull UUID id) implements Validatable {
  public ClimberId(@NotNull UUID id) {
    this.id = id;
    validate();
  }

  @Override
  public String toString() {
    return id.toString();
  }
}
