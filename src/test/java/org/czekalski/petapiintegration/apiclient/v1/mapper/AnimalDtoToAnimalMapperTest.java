package org.czekalski.petapiintegration.apiclient.v1.mapper;

import org.czekalski.petapiintegration.apiclient.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.apiclient.v1.dto.BreedsDto;
import org.czekalski.petapiintegration.resourceserver.model.Animal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalDtoToAnimalMapperTest {

    private static final String PRIMARY = "Labrador Retriever";
    private static final String AGE = "Adult";
    private static final String GENDER = "Female";
    private static final int ID = 1;
    private static final String NAME = "Reksia";
    private final Mapper<AnimalDto, Animal> animalMapper = new AnimalDtoToAnimalMapper();

    @Test
    void shouldMapAnimalDtoToAnimal() {
        //given
        BreedsDto breedsDto = new BreedsDto(
                PRIMARY, null, false, false);
        AnimalDto animalDto = new AnimalDto(
                ID, null, null, null, null, breedsDto,
                null, AGE, GENDER, null, null, null,
                null, null, NAME, null, null,
                null, null, null, null, null);

        //when
        Animal animal = animalMapper.map(animalDto);

        //then
        assertEquals(ID, animal.getId());
        assertEquals(NAME, animal.getName());
        assertEquals(PRIMARY, animal.getBreed());
        assertEquals(AGE, animal.getAge());
        assertEquals(GENDER, animal.getGender());
    }


    @Test
    void shouldMapNullToAnimal() {
        //given
        AnimalDto animalDto = null;

        //when
        Animal animal = animalMapper.map(animalDto);

        //then
        assertThat(animal).isNull();
    }

    @Test
    void shouldMapAnimalDtoWithNullFieldsToAnimal() {
        //given
        AnimalDto animalDto = new AnimalDto(
                0, null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null);

        //when
        Animal animal = animalMapper.map(animalDto);

        //then
        assertThat(animal).isNotNull();
    }
}