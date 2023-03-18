package com.opencodely.codelyhexagonal.climber.domain;


import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import jakarta.validation.constraints.Email;

public record EmailAddress(@Email String value) implements Validatable {

    public EmailAddress(String value) {
        this.value = value;
        validate();
    }
}
