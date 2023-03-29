package com.opencodely.codelyhexagonal.ascent.domain;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AscentId(@NotNull UUID id) {

  @Override
  public String toString() {
    return id.toString();
  }

}

