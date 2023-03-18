package com.opencodely.codelyhexagonal.climber.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimberJpaRepository extends JpaRepository<ClimberJpaEntity, Long> {
}
