package com.opencodely.codelyhexagonal.ascent.aplication;

import com.opencodely.codelyhexagonal.ascent.domain.Ascent;
import com.opencodely.codelyhexagonal.ascent.domain.AscentRepository;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import com.opencodely.codelyhexagonal.shared.application.UseCase;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class AddAscentApplicationService {
    private final AscentRepository ascentRepository;
    private final DomainEventPublisher eventPublisher;

    //Should we validate the existence of the climber and the route in this layer?
    public Long addAscent(Long climberId, Long routeId, Grade proposedGrade) {
        Ascent ascent = Ascent.createDraft(climberId, routeId, proposedGrade);
        Long id = ascentRepository.save(ascent);
        ascent.recordNewAscent(id);
        eventPublisher.publish(ascent.pullEvents());
        return id;
    }
}
