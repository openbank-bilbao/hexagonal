package com.opencodely.codelyhexagonal.route.infrastructure.persistance;

import com.opencodely.codelyhexagonal.route.domain.Crag;
import com.opencodely.codelyhexagonal.route.domain.Route;
import com.opencodely.codelyhexagonal.shared.infrastructure.JpaMapper;
import org.springframework.stereotype.Component;

@Component
public class RouteJpaMapper implements JpaMapper<Route, RouteJpaEntity> {
  @Override
  public RouteJpaEntity toJpaEntity(Route route) {
    return new RouteJpaEntity(route.getId(), route.getName(), route.getCrag().name(), route.getBaseGrade(),
      route.getConsensusGrade(), route.getAscentNumber());
  }

  @Override
  public Route toDomainEntity(RouteJpaEntity jpaRoute) {
    return new Route(jpaRoute.getId(), jpaRoute.getName(), new Crag(jpaRoute.getCrag()), jpaRoute.getBaseGrade(),
      jpaRoute.getConsensusGrade(), jpaRoute.getAscentNumber());
  }
}
