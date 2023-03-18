package com.opencodely.codelyhexagonal.ascent.infrastructure.web;

public record AddAscentResponse(String url) {
    public static AddAscentResponse from(String baseUrl, Long ascentId) {
        return new AddAscentResponse(baseUrl + ascentId);
    }
}
