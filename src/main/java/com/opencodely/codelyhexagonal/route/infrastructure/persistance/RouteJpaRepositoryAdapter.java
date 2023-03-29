package com.opencodely.codelyhexagonal.route.infrastructure.persistance;

import com.opencodely.codelyhexagonal.route.domain.Route;
import com.opencodely.codelyhexagonal.route.domain.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RouteJpaRepositoryAdapter implements RouteRepository {
  private final RouteJpaRepository repository;
  private final RouteJpaMapper mapper;

  @Override
  public Long save(Route route) {
    RouteJpaEntity jpaRoute = repository.save(mapper.toJpaEntity(route));
    return jpaRoute.getId();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Route> findById(Long id) {
    return repository.findById(id).map(mapper::toDomainEntity);
  }
}
