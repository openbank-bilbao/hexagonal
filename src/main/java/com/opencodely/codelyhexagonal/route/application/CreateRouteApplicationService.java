package com.opencodely.codelyhexagonal.route.application;

import com.opencodely.codelyhexagonal.route.domain.Route;
import com.opencodely.codelyhexagonal.route.domain.RouteRepository;
import com.opencodely.codelyhexagonal.shared.application.UseCase;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class CreateRouteApplicationService {
  private final RouteRepository routeRepository;
  private final DomainEventPublisher eventPublisher;

  public void create(UUID id, String name, String crag, Grade baseGrade) {
    Route route = Route.createRoute(id, name, crag, baseGrade);
    routeRepository.save(route);
    eventPublisher.publish(route.pullEvents());
  }
}
