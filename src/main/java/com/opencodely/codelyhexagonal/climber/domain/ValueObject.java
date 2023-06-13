package com.opencodely.codelyhexagonal.climber.domain;

import com.opencodely.codelyhexagonal.shared.domain.Validatable;

public class ValueObject<T> implements Validatable {

  private final T value;

  public ValueObject(final T value) {
    this.value = value;
    validate();
  }

  public T getValue() {
    return value;
  }

  public String toString() {
    return value.toString();
  }

}
