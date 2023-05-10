package com.opencodely.codelyhexagonal.ascent.domain;

import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AscentRoute(@NotNull UUID id, String name) implements Validatable {

  public AscentRoute(UUID id) {
    this(id, "");
  }

  public AscentRoute(UUID id, String name) {
    this.id = id;
    this.name = name;
    validate();
  }
}
