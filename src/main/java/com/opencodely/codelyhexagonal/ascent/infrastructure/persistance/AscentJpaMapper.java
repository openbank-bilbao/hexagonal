package com.opencodely.codelyhexagonal.ascent.infrastructure.persistance;

import com.opencodely.codelyhexagonal.ascent.domain.AscensionDate;
import com.opencodely.codelyhexagonal.ascent.domain.Ascent;
import com.opencodely.codelyhexagonal.ascent.domain.AscentClimber;
import com.opencodely.codelyhexagonal.ascent.domain.AscentId;
import com.opencodely.codelyhexagonal.ascent.domain.AscentRoute;
import com.opencodely.codelyhexagonal.climber.infrastructure.persistance.ClimberJpaEntity;
import com.opencodely.codelyhexagonal.route.infrastructure.persistance.RouteJpaEntity;
import com.opencodely.codelyhexagonal.shared.infrastructure.JpaMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AscentJpaMapper implements JpaMapper<Ascent, AscentJpaEntity> {

  @Override
  public AscentJpaEntity toJpaEntity(final Ascent ascent) {
    return AscentJpaEntity.builder()
        .id(ascent.getId().id().toString())
        .climber(ClimberJpaEntity.builder().id(ascent.getClimber().id().toString()).build())
        .route(RouteJpaEntity.builder().id(ascent.getRoute().id().toString()).build())
        .proposedGrade(ascent.getProposedGrade())
        .ascensionDate(ascent.getAscensionDate().date()).build();
  }

  @Override
  public Ascent toDomainEntity(final AscentJpaEntity jpaAscent) {
    final AscentClimber ascentClimber =
      new AscentClimber(UUID.fromString(jpaAscent.getClimber().getId()), jpaAscent.getClimber().getName());
    final AscentRoute ascentRoute = new AscentRoute(UUID.fromString(jpaAscent.getRoute().getId()), jpaAscent.getRoute().getName());
    return new Ascent(new AscentId(UUID.fromString(jpaAscent.getId())), ascentClimber, ascentRoute, jpaAscent.getProposedGrade(),
      new AscensionDate(jpaAscent.getAscensionDate()));
  }
}
