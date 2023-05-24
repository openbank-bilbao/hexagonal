package com.opencodely.codelyhexagonal.route.infrastructure.web;

import java.util.UUID;

public record RouteCreatedResponse(String url) {
  public static RouteCreatedResponse from(String baseUrl, UUID routeId) {
    return new RouteCreatedResponse(baseUrl + routeId);
  }
}
