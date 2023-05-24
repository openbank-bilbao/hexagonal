package com.opencodely.codelyhexagonal.route.domain;

import java.util.Optional;
import java.util.UUID;

public interface RouteRepository {
  void save(Route route);

  Optional<Route> findById(String id);
}
