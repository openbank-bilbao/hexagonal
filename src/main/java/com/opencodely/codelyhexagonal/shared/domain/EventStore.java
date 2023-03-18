package com.opencodely.codelyhexagonal.shared.domain;

import com.opencodely.codelyhexagonal.shared.domain.event.DomainEvent;

import java.util.List;

public interface EventStore {
    List<DomainEvent> pullEvents();
    void recordEvent(DomainEvent event);
}
