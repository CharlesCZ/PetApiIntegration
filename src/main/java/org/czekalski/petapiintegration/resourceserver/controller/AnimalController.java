package org.czekalski.petapiintegration.resourceserver.controller;

import org.czekalski.petapiintegration.config.AnimalRepresentationModelAssembler;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceserver.service.AnimalService;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnimalController {
    private final AnimalService animalService;
    private static final AnimalRepresentationModelAssembler ANIMAL_REPRESENTATION_MODEL_ASSEMBLER = new AnimalRepresentationModelAssembler();

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/dogs/{stateId}/{cityId}")
    public EntityModel<AnimalResourcesListDto> getDogsFromCity(
            @PathVariable String stateId,
            @PathVariable String cityId,
            @RequestParam int size,
            @RequestParam("page") int page) {

        return ANIMAL_REPRESENTATION_MODEL_ASSEMBLER
                .toModel(animalService
                        .findDogsByCityIdAndStateId(stateId, cityId, size, page), stateId, cityId, size, page);
    }

}
