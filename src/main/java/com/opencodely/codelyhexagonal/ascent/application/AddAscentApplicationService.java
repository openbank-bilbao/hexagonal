package com.opencodely.codelyhexagonal.ascent.application;

import com.opencodely.codelyhexagonal.ascent.domain.Ascent;
import com.opencodely.codelyhexagonal.ascent.domain.AscentRepository;
import com.opencodely.codelyhexagonal.shared.application.UseCase;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class AddAscentApplicationService {

  private final AscentRepository ascentRepository;
  private final DomainEventPublisher eventPublisher;

  //Should we validate the existence of the climber and the route in this layer?
  //Or let the database do it??
  public void addAscent(final UUID id, final UUID climberId, final UUID routeId,
                        final Grade proposedGrade, final LocalDate ascentDate) {
    final Ascent ascent = Ascent.createAscent(id, climberId, routeId, proposedGrade, ascentDate);
    ascentRepository.save(ascent);
    eventPublisher.publish(ascent.pullEvents());
  }

}
