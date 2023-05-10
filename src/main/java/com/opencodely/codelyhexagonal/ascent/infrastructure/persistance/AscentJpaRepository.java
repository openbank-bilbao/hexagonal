package com.opencodely.codelyhexagonal.ascent.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AscentJpaRepository extends JpaRepository<AscentJpaEntity, String> {
}
