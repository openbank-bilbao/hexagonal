package com.opencodely.codelyhexagonal.route.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RouteJpaRepository extends JpaRepository<RouteJpaEntity, String> {
}
