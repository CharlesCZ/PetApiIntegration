package org.czekalski.petapiintegration.resourceserver.service;

import org.czekalski.petapiintegration.apiclient.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.apiclient.v1.dto.AnimalsListDto;
import org.czekalski.petapiintegration.apiclient.v1.dto.BreedsDto;
import org.czekalski.petapiintegration.apiclient.v1.dto.PaginationDto;
import org.czekalski.petapiintegration.apiclient.v1.mapper.AnimalDtoToAnimalMapper;
import org.czekalski.petapiintegration.apiclient.v1.mapper.Mapper;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.mapper.AnimalToAnimalResourceDtoMapper;
import org.czekalski.petapiintegration.resourceserver.model.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class AnimalServiceTest {
    private static final String CITY_ID = "Andover";
    private static final String STATE_ID = "MA";
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
    private static final int SIZE = 2;
    public static final String URL = "https://api.petfinder.com/v2/animals?type=dog";

    private final Mapper<AnimalDto, Animal> animalDtoAnimal = new AnimalDtoToAnimalMapper();

    private final Mapper<Animal, AnimalResourceDto> animalToAnimalResourceDto = new AnimalToAnimalResourceDtoMapper();

    @Mock
    private OAuth2RestTemplate oAuth2RestTemplate;

    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        animalService = new AnimalServiceImpl(animalDtoAnimal, animalToAnimalResourceDto, oAuth2RestTemplate, URL);
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
        given(oAuth2RestTemplate.getForObject(URL + "&location=" + CITY_ID + ", " + STATE_ID + "&limit=" + SIZE+"&page="+CURRENT_PAGE, AnimalsListDto.class))
                .willReturn(new AnimalsListDto(Arrays.asList(animalDto, animalDto2), paginationDto));

        //when
        AnimalResourcesListDto animalResourcesListDto = animalService.findDogsByCityIdAndStateId(STATE_ID,CITY_ID,SIZE,CURRENT_PAGE);

        //then
        then(oAuth2RestTemplate).should().getForObject(URL + "&location=" + CITY_ID + ", " + STATE_ID + "&limit=" + SIZE+"&page="+CURRENT_PAGE, AnimalsListDto.class);
        assertEquals(COUNT_PER_PAGE, animalResourcesListDto.getPagination().getPageable().getPageSize());
        assertEquals(TOTAL_COUNT, animalResourcesListDto.getPagination().getTotalElements());
        assertEquals(CURRENT_PAGE, animalResourcesListDto.getPagination().getPageable().getPageNumber());
        assertEquals(TOTAL_PAGES, animalResourcesListDto.getPagination().getTotalPages());
    }
}