package com.opencodely.codelyhexagonal.ascent.infrastructure.persistance;

import com.opencodely.codelyhexagonal.ascent.domain.Ascent;
import com.opencodely.codelyhexagonal.ascent.domain.AscentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AscentJpaRepositoryAdapter implements AscentRepository {

  private final AscentJpaRepository ascentJpaRepository;
  private final AscentJpaMapper mapper;

  @Override
  public void save(final Ascent ascent) {
    ascentJpaRepository.save(mapper.toJpaEntity(ascent));
  }
}
