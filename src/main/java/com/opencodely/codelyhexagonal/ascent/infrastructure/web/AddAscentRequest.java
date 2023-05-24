package com.opencodely.codelyhexagonal.ascent.infrastructure.web;

import com.opencodely.codelyhexagonal.shared.domain.Grade;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record AddAscentRequest(@NotNull String climberId, @NotNull String routeId, Grade proposedGrade,
                               @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDate ascensionDate) {
}
