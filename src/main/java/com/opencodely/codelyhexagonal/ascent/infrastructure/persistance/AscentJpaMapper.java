package com.opencodely.codelyhexagonal.ascent.infrastructure.persistance;

import com.opencodely.codelyhexagonal.ascent.domain.AscensionDate;
import com.opencodely.codelyhexagonal.ascent.domain.Ascent;
import com.opencodely.codelyhexagonal.ascent.domain.AscentClimber;
import com.opencodely.codelyhexagonal.ascent.domain.AscentRoute;
import com.opencodely.codelyhexagonal.climber.infrastructure.persistance.ClimberJpaEntity;
import com.opencodely.codelyhexagonal.route.infrastructure.persistance.RouteJpaEntity;
import com.opencodely.codelyhexagonal.shared.infrastructure.JpaMapper;
import org.springframework.stereotype.Component;

@Component
public class AscentJpaMapper implements JpaMapper<Ascent, AscentJpaEntity> {
    @Override
    public AscentJpaEntity toJpaEntity(Ascent ascent) {
        return AscentJpaEntity.builder()
            .id(ascent.getId())
            .climber(ClimberJpaEntity.builder().id(ascent.getClimber().id()).build())
            .route(RouteJpaEntity.builder().id(ascent.getRoute().id()).build())
            .proposedGrade(ascent.getProposedGrade())
            .ascensionDate(ascent.getAscensionDate().date()).build();
    }

    @Override
    public Ascent toDomainEntity(AscentJpaEntity jpaAscent) {
        AscentClimber ascentClimber =
            new AscentClimber(jpaAscent.getClimber().getId(), jpaAscent.getClimber().getName());
        AscentRoute ascentRoute = new AscentRoute(jpaAscent.getRoute().getId(), jpaAscent.getRoute().getName());
        return new Ascent(jpaAscent.getId(), ascentClimber, ascentRoute, jpaAscent.getProposedGrade(),
            new AscensionDate(jpaAscent.getAscensionDate()));
    }
}
