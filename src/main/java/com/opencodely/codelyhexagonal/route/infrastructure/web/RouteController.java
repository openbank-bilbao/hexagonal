package com.opencodely.codelyhexagonal.route.infrastructure.web;

import com.opencodely.codelyhexagonal.route.application.CreateRouteApplicationService;
import com.opencodely.codelyhexagonal.shared.domain.IdProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RouteController {
  private final CreateRouteApplicationService createRouteService;
  private final IdProvider<UUID> idProvider;

  @PostMapping(RouteUrl.BASE_V1)
  @ResponseStatus(HttpStatus.CREATED)
  public RouteCreatedResponse create(@RequestBody @Valid RouteCreateRequest routeCreateRequest) {
    final var uuid = idProvider.provide();
    createRouteService.create(uuid, routeCreateRequest.name(), routeCreateRequest.crag(), routeCreateRequest.baseGrade());
    return RouteCreatedResponse.from(RouteUrl.BASE_V1, uuid);
  }
}
