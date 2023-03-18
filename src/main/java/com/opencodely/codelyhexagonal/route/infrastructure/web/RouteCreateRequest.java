package com.opencodely.codelyhexagonal.route.infrastructure.web;

import com.opencodely.codelyhexagonal.shared.domain.Grade;

public record RouteCreateRequest(String name, String crag, Grade baseGrade) {
}
