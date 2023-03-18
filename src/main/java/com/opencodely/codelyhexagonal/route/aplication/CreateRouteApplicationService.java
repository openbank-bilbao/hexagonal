package com.opencodely.codelyhexagonal.route.aplication;

import com.opencodely.codelyhexagonal.route.domain.Route;
import com.opencodely.codelyhexagonal.route.domain.RouteRepository;
import com.opencodely.codelyhexagonal.shared.application.UseCase;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateRouteApplicationService {
    private final RouteRepository routeRepository;
    private final DomainEventPublisher eventPublisher;

    public Long create(String name, String crag, Grade baseGrade) {
        Route route = Route.draftRoute(name, crag, baseGrade);
        Long id = routeRepository.save(route);
        route.recordRouteCreatedEvent(id);
        eventPublisher.publish(route.pullEvents());
        return id;
    }
}
