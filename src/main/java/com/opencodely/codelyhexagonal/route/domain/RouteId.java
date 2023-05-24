package com.opencodely.codelyhexagonal.route.domain;

import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RouteId(@NotNull UUID id) implements Validatable {
  public RouteId(@NotNull UUID id) {
    this.id = id;
    validate();
  }

  @Override
  public String toString() {
    return id.toString();
  }
}
