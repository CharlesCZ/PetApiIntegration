package org.czekalski.petapiintegration.resourceserver.controller;

import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceserver.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/dogs/{stateId}/{cityId}")
    public AnimalResourcesListDto getDogsFromCity(
            @PathVariable String stateId,
            @PathVariable String cityId,
            @RequestParam int size,
            @RequestParam("page") int page) {
        return animalService.findDogsByCityIdAndStateId(stateId, cityId, size, page);
    }

}
