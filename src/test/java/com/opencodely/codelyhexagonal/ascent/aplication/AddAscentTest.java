package com.opencodely.codelyhexagonal.ascent.aplication;

import static org.junit.jupiter.api.Assertions.*;

import com.opencodely.codelyhexagonal.ascent.domain.AscentRepository;
import com.opencodely.codelyhexagonal.shared.domain.DomainEventPublisher;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddAscentTest {

    @Mock
    private AscentRepository ascentRepository;
    @Mock
    private DomainEventPublisher domainEventPublisher;
    private final AddAscentApplicationService addAscentUseCase =
        new AddAscentApplicationService(ascentRepository, domainEventPublisher);
}
