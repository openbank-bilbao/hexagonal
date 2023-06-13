package com.opencodely.codelyhexagonal.climber.domain;

import static org.instancio.Select.field;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClimberObjectMother {

  public static Climber random() {
    return Instancio.of(Climber.class)
      .set(field(Climber::getEmail), new EmailAddress("hola@hola.com")).create();
  }

}
