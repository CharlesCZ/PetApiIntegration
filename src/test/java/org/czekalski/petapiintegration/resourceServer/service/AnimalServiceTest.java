package org.czekalski.petapiintegration.resourceServer.service;

import org.czekalski.petapiintegration.apiClient.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.apiClient.v1.dto.AnimalsListDto;
import org.czekalski.petapiintegration.apiClient.v1.dto.BreedsDto;
import org.czekalski.petapiintegration.apiClient.v1.dto.PaginationDto;
import org.czekalski.petapiintegration.apiClient.v1.mapper.AnimalDtoToAnimal;
import org.czekalski.petapiintegration.apiClient.v1.mapper.Mapper;
import org.czekalski.petapiintegration.apiClient.v1.mapper.PaginationDtoToPagination;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.PaginationResourceDto;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.mapper.AnimalToAnimalResourceDto;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.mapper.PaginationToPaginationResource;
import org.czekalski.petapiintegration.resourceServer.model.Animal;
import org.czekalski.petapiintegration.resourceServer.model.Pagination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


class AnimalServiceTest {
    private static final String API_REQUEST_URI = "https://api.petfinder.com/v2/animals?location=Andover, MA&distance=2";
    private static final String LOCATION = "Androver, MA";
    private static final String PRIMARY = "Labrador Retriever";
    private static final String AGE = "Adult";
    private static final String GENDER = "Female";
    private static final int ID = 1;
    private static final int ID_2 = 2;
    private static final String NAME = "Reksia";
    private static final int COUNT_PER_PAGE = 10;
    private static final int TOTAL_COUNT = 3000;
    private static final int CURRENT_PAGE = 1;
    private static final int TOTAL_PAGES = 300;
    public static final int SIZE = 2;

    private final Mapper<AnimalDto, Animal> animalDtoAnimal = new AnimalDtoToAnimal();

    private final Mapper<PaginationDto, Pagination> paginationDtoToPagination = new PaginationDtoToPagination();

    private final Mapper<Animal, AnimalResourceDto> animalToAnimalResourceDto = new AnimalToAnimalResourceDto();

    private final Mapper<Pagination, PaginationResourceDto> paginationToPaginationResourceDto = new PaginationToPaginationResource();

    @Mock
    private OAuth2RestTemplate oAuth2RestTemplate;

    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        animalService = new AnimalServiceImpl(animalDtoAnimal, animalToAnimalResourceDto, oAuth2RestTemplate);
    }

    @Test
    void findDogsByCityIdAndDogsQuantity() {
        //given
        BreedsDto breedsDto = new BreedsDto(PRIMARY, null, false, false);
        AnimalDto animalDto = new AnimalDto(
                ID, null, null, null, null, breedsDto, null, AGE, GENDER, null, null, null,
                null, null, NAME, null, null, null, null, null, null, null);
        AnimalDto animalDto2 = new AnimalDto(
                ID_2, null, null, null, null, breedsDto, null, AGE, GENDER, null, null, null,
                null, null, NAME, null, null, null, null, null, null, null);
        PaginationDto paginationDto = new PaginationDto(COUNT_PER_PAGE, TOTAL_COUNT, CURRENT_PAGE, TOTAL_PAGES);
        given(oAuth2RestTemplate.getForObject(API_REQUEST_URI, AnimalsListDto.class))
                .willReturn(new AnimalsListDto(Arrays.asList(animalDto, animalDto2), paginationDto));

        //when
        AnimalResourcesListDto animalResourcesListDto = animalService.findDogsByCityIdAndDogsQuantity(LOCATION, SIZE);

        //then
        then(oAuth2RestTemplate).should().getForObject(API_REQUEST_URI, AnimalsListDto.class);
        assertThat(animalResourcesListDto.getContent()).hasSize(2);
        assertEquals(COUNT_PER_PAGE, animalResourcesListDto.getPagination().getCountPerPage());
        assertEquals(TOTAL_COUNT, animalResourcesListDto.getPagination().getTotalCount());
        assertEquals(CURRENT_PAGE, animalResourcesListDto.getPagination().getCurrentPage());
        assertEquals(TOTAL_PAGES, animalResourcesListDto.getPagination().getTotalPages());


    }
}