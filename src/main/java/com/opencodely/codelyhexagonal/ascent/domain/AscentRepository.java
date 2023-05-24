package com.opencodely.codelyhexagonal.ascent.domain;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AscentRepository {

  void save(Ascent ascent);
}
