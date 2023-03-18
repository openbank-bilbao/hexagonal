package com.opencodely.codelyhexagonal.climber.infrastructure.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClimberCreateRequest(@NotBlank String name, @NotBlank @Email String email) {
}
