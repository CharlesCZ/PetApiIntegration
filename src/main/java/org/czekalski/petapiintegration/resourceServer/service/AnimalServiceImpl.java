package org.czekalski.petapiintegration.resourceServer.service;

import org.czekalski.petapiintegration.apiClient.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.apiClient.v1.mapper.AnimalDtoToAnimal;
import org.czekalski.petapiintegration.apiClient.v1.mapper.Mapper;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.mapper.AnimalToAnimalResourceDto;
import org.czekalski.petapiintegration.resourceServer.model.Animal;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final Mapper animalDtoToAnimal;
    private final Mapper animalToAnimalResourceDto;
    private final OAuth2RestTemplate oAuth2RestTemplate;

    public AnimalServiceImpl(Mapper animalDtoToAnimal, Mapper animalToAnimalResourceDto, OAuth2RestTemplate oAuth2RestTemplate) {
        this.animalDtoToAnimal = animalDtoToAnimal;
        this.animalToAnimalResourceDto = animalToAnimalResourceDto;
        this.oAuth2RestTemplate = oAuth2RestTemplate;
    }

    @Override
    public AnimalResourcesListDto findDogsByCityIdAndDogsQuantity(String cityId, int size) {
        return null;
    }
}
