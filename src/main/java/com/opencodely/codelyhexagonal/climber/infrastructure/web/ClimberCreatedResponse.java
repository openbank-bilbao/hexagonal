package com.opencodely.codelyhexagonal.climber.infrastructure.web;

public record ClimberCreatedResponse(String url) {
    public static ClimberCreatedResponse from(String baseUrl, Long climberId) {
        return new ClimberCreatedResponse(baseUrl + climberId);
    }
}
