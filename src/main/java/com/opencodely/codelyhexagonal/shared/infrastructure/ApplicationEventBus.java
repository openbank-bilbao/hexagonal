package com.opencodely.codelyhexagonal.shared.infrastructure;

import com.opencodely.codelyhexagonal.shared.domain.event.ClimberCreatedDomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationEventBus implements DomainEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public <T extends DomainEvent> void publish(Collection<T> events) {
        events.forEach(this::publish);
    }

    @Override
    public <T extends DomainEvent> void publish(T event) {
        applicationEventPublisher.publishEvent(event);
    }

    @EventListener
    public void climberCreated(ClimberCreatedDomainEvent event) {
        log.info("Climber created event received on event bus {}", event);
    }

}
