package com.opencodely.codelyhexagonal.route.infrastructure.persistance;

import com.opencodely.codelyhexagonal.route.domain.Route;
import com.opencodely.codelyhexagonal.route.domain.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RouteJpaRepositoryAdapter implements RouteRepository {
  private final RouteJpaRepository repository;
  private final RouteJpaMapper mapper;

  @Override
  public void save(Route route) {
    repository.save(mapper.toJpaEntity(route));
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Route> findById(String id) {
    return repository.findById(id).map(mapper::toDomainEntity);
  }
}
