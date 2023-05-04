package com.opencodely.codelyhexagonal.shared.domain.event;

import com.opencodely.codelyhexagonal.route.domain.Route;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public final class RouteCreatedDomainEvent extends DomainEvent {
  private Data data;

  public RouteCreatedDomainEvent(UUID id, Instant creationTimestamp, Data data) {
    super(id, creationTimestamp);
    this.data = data;
  }

  public static RouteCreatedDomainEvent from(Route route) {
    return new RouteCreatedDomainEvent(UUID.randomUUID(), Instant.now(), new Data(route.getId(), route.getName()));
  }

  public record Data(long id, String name) {
  }
}
