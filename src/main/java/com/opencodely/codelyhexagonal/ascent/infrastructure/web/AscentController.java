package com.opencodely.codelyhexagonal.ascent.infrastructure.web;

import com.opencodely.codelyhexagonal.ascent.aplication.AddAscentApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AscentController {
    private final AddAscentApplicationService addAscentService;

    @PostMapping(AscentUrl.BASE_V1)
    @ResponseStatus(HttpStatus.CREATED)
    public AddAscentResponse create(@RequestBody @Valid AddAscentRequest request) {
        Long id = addAscentService.addAscent(request.climberId(), request.routeId(), request.proposedGrade());
        return AddAscentResponse.from(AscentUrl.BASE_V1, id);
    }
}
