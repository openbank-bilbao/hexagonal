package com.opencodely.codelyhexagonal.climber.infrastructure.persistance;

import com.opencodely.codelyhexagonal.climber.domain.Climber;
import com.opencodely.codelyhexagonal.climber.domain.ClimberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClimberJpaRepositoryAdapter implements ClimberRepository {

  private final ClimberJpaRepository climberJpaRepository;
  private final ClimberJpaMapper mapper;

  @Override
  public void save(Climber climber) {
    climberJpaRepository.save(mapper.toJpaEntity(climber));
  }
}
