package org.czekalski.petapiintegration.resourceServer.controller;

import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceServer.service.AnimalService;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
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

    @GetMapping("/dogs/{cityId}/{stateId}")
    public AnimalResourcesListDto getDogsFromCity(@PathVariable String cityId, @PathVariable String stateId, @RequestParam int size) {

        return null;
    }

}
