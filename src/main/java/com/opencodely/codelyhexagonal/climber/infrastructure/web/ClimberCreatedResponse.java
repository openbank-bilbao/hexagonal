package com.opencodely.codelyhexagonal.climber.infrastructure.web;

import java.util.UUID;

public record ClimberCreatedResponse(String url) {
  public static ClimberCreatedResponse from(String baseUrl, UUID climberId) {
    return new ClimberCreatedResponse(baseUrl + climberId);
  }
}
