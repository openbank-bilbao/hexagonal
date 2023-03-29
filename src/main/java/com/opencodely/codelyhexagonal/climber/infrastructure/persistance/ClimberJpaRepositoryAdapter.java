package com.opencodely.codelyhexagonal.climber.infrastructure.persistance;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.climber.domain.ClimberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClimberJpaRepositoryAdapter implements ClimberRepository {

  private final ClimberJpaRepository climberJpaRepository;
  private final ClimberJpaMapper mapper;

  @Override
  public Long save(Climber climber) {
    ClimberJpaEntity jpaClimber = climberJpaRepository.save(mapper.toJpaEntity(climber));
    return jpaClimber.getId();
  }
}
