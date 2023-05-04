package com.opencodely.codelyhexagonal.shared.domain;

import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;

import java.util.Collection;

public interface DomainEventPublisher {
  <T extends DomainEvent> void publish(Collection<T> events);

  <T extends DomainEvent> void publish(T events);
}
