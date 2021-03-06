package org.czekalski.petapiintegration.server.service;

import org.czekalski.petapiintegration.client.api.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.client.api.v1.dto.AnimalsListDto;
import org.czekalski.petapiintegration.client.api.v1.mapper.Mapper;
import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.server.model.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final Mapper<AnimalDto, Animal> animalDtoToAnimalMapper;
    private final Mapper<Animal, AnimalResourceDto> animalToAnimalResourceDtoMapper;
    private final OAuth2RestTemplate oAuth2RestTemplate;
    private final String url;
    private static final Logger animalServiceImplLogger = LoggerFactory.getLogger(AnimalServiceImpl.class);

    public AnimalServiceImpl(
            Mapper animalDtoToAnimalMapper,
            Mapper animalToAnimalResourceDtoMapper,
            OAuth2RestTemplate oAuth2RestTemplate,
            @Value("${messages.base-uri}") String url) {
        this.animalDtoToAnimalMapper = animalDtoToAnimalMapper;
        this.animalToAnimalResourceDtoMapper = animalToAnimalResourceDtoMapper;
        this.oAuth2RestTemplate = oAuth2RestTemplate;
        this.url = url;
    }

    @Override
    public AnimalResourcesListDto findDogsByCityIdAndStateId(String stateId, String cityId, int size, int page) {
        UriComponents uriComponents= UriComponentsBuilder.fromUriString(url)
                .queryParam("location",cityId+", "+stateId)
                .queryParam("limit",size)
                .queryParam("page",page)
                .build();
        animalServiceImplLogger.trace("URL=" + uriComponents.toUriString());
        AnimalsListDto animalsListDto = oAuth2RestTemplate.getForObject(uriComponents.toUriString(), AnimalsListDto.class);

        List<AnimalResourceDto> animalResourceDto = animalsListDto.getAnimals()
                .stream()
                .map(animalDtoToAnimalMapper::map)
                .map(animalToAnimalResourceDtoMapper::map)
                .collect(Collectors.toList());

        Pageable pageable=PageRequest.of(animalsListDto.getPagination().getCurrentPage(), animalsListDto.getPagination().getCountPerPage(), Sort.Direction.ASC,"publishedAt");

        return new AnimalResourcesListDto(new PageImpl<>(animalResourceDto,pageable,animalsListDto.getPagination().getTotalCount()));
    }
}
