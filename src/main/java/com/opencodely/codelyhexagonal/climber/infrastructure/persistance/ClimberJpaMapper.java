package com.opencodely.codelyhexagonal.climber.infrastructure.persistance;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.climber.domain.EmailAddress;
import com.opencodely.codelyhexagonal.shared.infrastructure.JpaMapper;
import org.springframework.stereotype.Component;

@Component
public class ClimberJpaMapper implements JpaMapper<Climber, ClimberJpaEntity> {

    public ClimberJpaEntity toJpaEntity(Climber climber) {
        return new ClimberJpaEntity(climber.getId(), climber.getName(), climber.getEmail().value());
    }

    public Climber toDomainEntity(ClimberJpaEntity jpaClimber) {
        return new Climber(jpaClimber.getId(), jpaClimber.getName(), new EmailAddress(jpaClimber.getEmail()));
    }
}
