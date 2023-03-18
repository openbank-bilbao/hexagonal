package com.opencodely.codelyhexagonal.shared.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public abstract sealed class DomainEvent permits AscentAddedDomainEvent, ClimberCreatedDomainEvent, RouteCreatedDomainEvent{
    private UUID id;
    private Instant creationTimestamp;
    abstract Object getData();
}
