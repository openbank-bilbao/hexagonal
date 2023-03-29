package com.opencodely.codelyhexagonal.ascent.infrastructure.web;

import java.util.UUID;

public record AddAscentResponse(String url) {
  public static AddAscentResponse from(final String baseUrl, final UUID ascentId) {
    return new AddAscentResponse(baseUrl + ascentId);
  }
}
