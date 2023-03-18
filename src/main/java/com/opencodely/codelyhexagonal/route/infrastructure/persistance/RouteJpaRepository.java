package com.opencodely.codelyhexagonal.route.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteJpaRepository extends JpaRepository<RouteJpaEntity, Long> {
}
