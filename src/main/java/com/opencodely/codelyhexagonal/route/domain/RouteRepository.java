package com.opencodely.codelyhexagonal.route.domain;

import java.util.Optional;

public interface RouteRepository {
  Long save(Route route);

  Optional<Route> findById(Long id);
}
