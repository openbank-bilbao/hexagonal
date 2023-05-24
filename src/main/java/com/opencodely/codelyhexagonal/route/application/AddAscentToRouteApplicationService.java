package com.opencodely.codelyhexagonal.route.application;

import com.opencodely.codelyhexagonal.route.domain.Route;
import com.opencodely.codelyhexagonal.route.domain.RouteRepository;
import com.opencodely.codelyhexagonal.shared.application.UseCase;
import com.opencodely.codelyhexagonal.shared.domain.Exception.ResourceNotFoundException;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class AddAscentToRouteApplicationService {
  private final RouteRepository routeRepository;

  public void addAscentToRoute(UUID routeId, Grade proposedGrade) {
    Route route = routeRepository.findById(routeId.toString())
      .orElseThrow(() -> new ResourceNotFoundException(String.format("Route with id %s could not be found", routeId)));
    route.setConsensusGrade(Grade.averageGrade(List.of(route.getConsensusGrade(), proposedGrade)));
    route.addAscent();
    routeRepository.save(route);
  }
}
