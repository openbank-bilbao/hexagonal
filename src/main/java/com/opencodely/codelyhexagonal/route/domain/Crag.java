package com.opencodely.codelyhexagonal.route.domain;

import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import jakarta.validation.constraints.NotBlank;

public record Crag(@NotBlank String name) implements Validatable {
    public Crag(String name) {
        this.name = name;
        validate();
    }
}
