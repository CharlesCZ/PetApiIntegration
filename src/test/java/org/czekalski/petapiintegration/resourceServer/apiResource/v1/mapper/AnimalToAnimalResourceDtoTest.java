package org.czekalski.petapiintegration.resourceServer.apiResource.v1.mapper;

import org.czekalski.petapiintegration.apiClient.v1.mapper.Mapper;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceServer.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalToAnimalResourceDtoTest {
    private static final String BREED = "Labrador Retriever";
    private static final String AGE = "Adult";
    private static final String GENDER = "Female";
    private static final int ID = 1;
    private static final String NAME = "Reksia";
    private final Mapper<Animal, AnimalResourceDto> animalToAnimalResourceDto = new AnimalToAnimalResourceDto();

    @Test
    void map() {
        //given
        Animal animal = new Animal(ID, NAME, BREED, AGE, GENDER);

        //when
        AnimalResourceDto animalResourceDto = animalToAnimalResourceDto.map(animal);

        //then
        assertEquals(ID, animalResourceDto.getId());
        assertEquals(NAME, animalResourceDto.getName());
        assertEquals(BREED, animalResourceDto.getBreed());
        assertEquals(AGE, animalResourceDto.getAge());
        assertEquals(GENDER, animalResourceDto.getGender());
    }
}