package com.opencodely.codelyhexagonal.ascent.aplication;

import com.opencodely.codelyhexagonal.ascent.domain.Ascent;
import com.opencodely.codelyhexagonal.ascent.domain.AscentId;
import com.opencodely.codelyhexagonal.ascent.domain.AscentRepository;
import com.opencodely.codelyhexagonal.shared.application.UseCase;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AddAscentApplicationService {

  private final AscentRepository ascentRepository;
  private final DomainEventPublisher eventPublisher;

  //Should we validate the existence of the climber and the route in this layer?
  public void addAscent(final UUID id, final Long climberId, final Long routeId, final Grade proposedGrade) {
    final AscentId ascentId = new AscentId(id);
    final Ascent ascent = Ascent.createDraft(ascentId, climberId, routeId, proposedGrade);
    ascentRepository.save(ascent);
    ascent.recordNewAscent();
    eventPublisher.publish(ascent.pullEvents());
  }
}
