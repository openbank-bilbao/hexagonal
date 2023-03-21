package com.opencodely.codelyhexagonal.shared.infrastructure.provider;

import com.opencodely.codelyhexagonal.shared.domain.IdProvider;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UUIDv4IdProvider implements IdProvider<UUID> {

  @Override
  public UUID provide() {
    return UUID.randomUUID();
  }
}
