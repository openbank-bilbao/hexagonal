package com.opencodely.codelyhexagonal.climber.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClimberIdObjectMother {


  public static ClimberId random() {
    return Instancio.create(ClimberId.class);
  }
}
