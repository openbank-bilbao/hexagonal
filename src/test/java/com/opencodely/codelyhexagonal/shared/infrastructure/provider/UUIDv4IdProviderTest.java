package com.opencodely.codelyhexagonal.shared.infrastructure.provider;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UUIDv4IdProviderTest {

  private final UUIDv4IdProvider subject = new UUIDv4IdProvider();

  @Test
  void should_provide_uuid() {
    //when
    final var result = subject.provide();

    //then
    assertThat(result).isNotNull();
  }

}