package com.opencodely.codelyhexagonal.route.infrastructure.web;

public record RouteCreatedResponse(String url) {
  public static RouteCreatedResponse from(String baseUrl, Long routeId) {
    return new RouteCreatedResponse(baseUrl + routeId);
  }
}
