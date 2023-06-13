package com.opencodely.codelyhexagonal.climber.infrastructure.persistance;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.climber.domain.ClimberId;
import com.opencodely.codelyhexagonal.climber.domain.ClimberName;
import com.opencodely.codelyhexagonal.climber.domain.EmailAddress;
import com.opencodely.codelyhexagonal.shared.infrastructure.JpaMapper;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ClimberJpaMapper implements JpaMapper<Climber, ClimberJpaEntity> {

  public ClimberJpaEntity toJpaEntity(final Climber climber) {
    return new ClimberJpaEntity(
      climber.getId().id().toString(),
      climber.getName().getValue(),
      climber.getEmail().value()
    );
  }

  public Climber toDomainEntity(final ClimberJpaEntity jpaClimber) {
    return new Climber(
      new ClimberId(UUID.fromString(jpaClimber.getId())),
      new ClimberName(jpaClimber.getName()),
      new EmailAddress(jpaClimber.getEmail())
    );
  }
}
