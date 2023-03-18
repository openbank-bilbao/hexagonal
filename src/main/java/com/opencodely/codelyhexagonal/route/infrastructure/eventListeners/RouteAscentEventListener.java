package com.opencodely.codelyhexagonal.route.infrastructure.eventListeners;

import com.opencodely.codelyhexagonal.route.aplication.AddAscentToRouteApplicationService;
import com.opencodely.codelyhexagonal.shared.domain.event.AscentAddedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RouteAscentEventListener {
    private final AddAscentToRouteApplicationService addAscentToRouteApplicationService;

    @EventListener
    public void ascentAdded(AscentAddedDomainEvent event) {
        log.info("Ascent {} will be added to Route {}", event.getData().id(), event.getData().routeId());
        addAscentToRouteApplicationService.addAscentToRoute(event.getData().routeId(), event.getData().proposedGrade());
    }
}
