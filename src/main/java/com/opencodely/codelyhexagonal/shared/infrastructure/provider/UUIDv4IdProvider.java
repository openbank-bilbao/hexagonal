package com.opencodely.codelyhexagonal.shared.infrastructure.provider;

import com.opencodely.codelyhexagonal.shared.domain.IdProvider;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDv4IdProvider implements IdProvider<UUID> {

  @Override
  public UUID provide() {
    return UUID.randomUUID();
  }
}
