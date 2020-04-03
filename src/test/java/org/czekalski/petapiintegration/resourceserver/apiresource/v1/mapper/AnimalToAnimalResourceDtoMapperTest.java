package org.czekalski.petapiintegration.resourceserver.apiresource.v1.mapper;

import org.czekalski.petapiintegration.apiclient.v1.mapper.Mapper;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceserver.model.Animal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalToAnimalResourceDtoMapperTest {
    private static final String BREED = "Labrador Retriever";
    private static final String AGE = "Adult";
    private static final String GENDER = "Female";
    private static final int ID = 1;
    private static final String NAME = "Reksia";
    private final Mapper<Animal, AnimalResourceDto> animalToAnimalResourceDto = new AnimalToAnimalResourceDtoMapper();

    @Test
    void animalToAnimalResourceDto() {
        //given
        Animal animal = new Animal.AnimalBuilder()
                .setId(ID)
                .setName(NAME)
                .setBreed(BREED)
                .setAge(AGE)
                .setGender(GENDER).build();

        //when
        AnimalResourceDto animalResourceDto = animalToAnimalResourceDto.map(animal);

        //then
        assertEquals(ID, animalResourceDto.getId());
        assertEquals(NAME, animalResourceDto.getName());
        assertEquals(BREED, animalResourceDto.getBreed());
        assertEquals(AGE, animalResourceDto.getAge());
        assertEquals(GENDER, animalResourceDto.getGender());
    }

    @Test
    void nullToAnimalResourceDto() {
        //given
        Animal animal = null;

        //when
        AnimalResourceDto animalResourceDto = animalToAnimalResourceDto.map(animal);

        //then
        assertThat(animalResourceDto).isNull();
    }
}