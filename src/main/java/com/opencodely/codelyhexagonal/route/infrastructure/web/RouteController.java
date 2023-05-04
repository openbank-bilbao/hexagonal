package com.opencodely.codelyhexagonal.route.infrastructure.web;

import com.opencodely.codelyhexagonal.route.aplication.CreateRouteApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RouteController {
  private final CreateRouteApplicationService createRouteService;

  @PostMapping(RouteUrl.BASE_V1)
  @ResponseStatus(HttpStatus.CREATED)
  public RouteCreatedResponse create(@RequestBody @Valid RouteCreateRequest routeCreateRequest) {
    Long id =
      createRouteService.create(routeCreateRequest.name(), routeCreateRequest.crag(), routeCreateRequest.baseGrade());
    return RouteCreatedResponse.from(RouteUrl.BASE_V1, id);
  }
}
