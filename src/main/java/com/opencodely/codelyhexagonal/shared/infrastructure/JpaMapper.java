package com.opencodely.codelyhexagonal.shared.infrastructure;

public interface JpaMapper <D, J> {
    J toJpaEntity(D domainEntity);
    D toDomainEntity(J jpaEntity);
}
