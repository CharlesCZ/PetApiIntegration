package org.czekalski.petapiintegration.resourceServer.service;

import org.czekalski.petapiintegration.apiClient.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.apiClient.v1.dto.AnimalsListDto;
import org.czekalski.petapiintegration.apiClient.v1.dto.PaginationDto;
import org.czekalski.petapiintegration.apiClient.v1.mapper.Mapper;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.PaginationResourceDto;
import org.czekalski.petapiintegration.resourceServer.model.Animal;
import org.czekalski.petapiintegration.resourceServer.model.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final Mapper<AnimalDto, Animal> animalDtoToAnimal;
    private final Mapper<PaginationDto, Pagination> paginationDtoToPagination;
    private final Mapper<Animal, AnimalResourceDto> animalToAnimalResourceDto;
    private final Mapper<Pagination, PaginationResourceDto> paginationToPaginationResourceDto;
    private final OAuth2RestTemplate oAuth2RestTemplate;
    private final String url;
    private final Logger logger;

    public AnimalServiceImpl(Mapper animalDtoToAnimal, Mapper paginationDtoToPagination, Mapper animalToAnimalResourceDto, Mapper paginationToPaginationResourceDto, OAuth2RestTemplate oAuth2RestTemplate, @Value("${messages.base-uri}") String url) {
        this.animalDtoToAnimal = animalDtoToAnimal;
        this.paginationDtoToPagination = paginationDtoToPagination;
        this.animalToAnimalResourceDto = animalToAnimalResourceDto;
        this.paginationToPaginationResourceDto = paginationToPaginationResourceDto;
        this.oAuth2RestTemplate = oAuth2RestTemplate;
        this.url = url;
        logger = LoggerFactory.getLogger(AnimalServiceImpl.class);
    }

    @Override
    public AnimalResourcesListDto findDogsByCityIdAndDogsQuantity(String cityId, String stateId, int size) {
        logger.info("URL=" + url + "&location=" + cityId + ", " + stateId + "&limit=" + size);
        AnimalsListDto animalsListDto = oAuth2RestTemplate.getForObject(url + "&location=" + cityId + ", " + stateId + "&limit=" + size, AnimalsListDto.class);
        PaginationResourceDto paginationResourceDto = paginationToPaginationResourceDto.map(
                paginationDtoToPagination.map(animalsListDto.getPagination()));

        List<AnimalResourceDto> animalResourceDto = animalsListDto.getAnimals()
                .stream()
                .map(animalDtoToAnimal::map)
                .map(animalToAnimalResourceDto::map)
                .collect(Collectors.toList());

        return new AnimalResourcesListDto(animalResourceDto, paginationResourceDto);
    }
}
