package com.opencodely.codelyhexagonal.shared.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.groups.Default;

import java.util.Set;

public interface Validatable {

  default void validate(Validatable this, Class<?> clazz) {
    try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
      Validator validator = factory.getValidator();
      Set<ConstraintViolation<Validatable>> violations = validator.validate(this, clazz);
      if (!violations.isEmpty()) {
        throw new ConstraintViolationException(violations);
      }
    }
  }

  default void validate(Validatable this) {
    this.validate(Default.class);
  }
}
