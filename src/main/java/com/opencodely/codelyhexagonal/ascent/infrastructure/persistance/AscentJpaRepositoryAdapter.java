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
    public Long save(Ascent ascent) {
        AscentJpaEntity jpaAscent = ascentJpaRepository.save(mapper.toJpaEntity(ascent));
        return jpaAscent.getId();
    }
}
