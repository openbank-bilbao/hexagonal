package com.opencodely.codelyhexagonal.climber.domain;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailAddressTest {

    @Test
    void should_throw_on_malformed_email() {
        assertThrows(ConstraintViolationException.class, () -> new EmailAddress("wrong"));
    }
}
