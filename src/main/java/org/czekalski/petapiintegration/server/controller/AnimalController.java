package org.czekalski.petapiintegration.server.controller;

import org.czekalski.petapiintegration.infrastructure.factory.animal.AnimalPageCaseFactory;
import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.server.service.AnimalService;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnimalController {
    private final AnimalService animalService;
    private final AnimalPageCaseFactory animalPageCaseFactory;

    public AnimalController(AnimalService animalService, AnimalPageCaseFactory animalPageCaseFactory) {
        this.animalService = animalService;
        this.animalPageCaseFactory = animalPageCaseFactory;
    }

    @GetMapping("/dogs/{stateId}/{cityId}")
    public EntityModel<AnimalResourcesListDto> getDogsFromCity(
            @PathVariable String stateId,
            @PathVariable String cityId,
            @RequestParam int size,
            @RequestParam("page") int page) {

        return animalPageCaseFactory
                .toModel(animalService.findDogsByCityIdAndStateId(stateId, cityId, size, page),
                        stateId,
                        cityId);
    }

}
