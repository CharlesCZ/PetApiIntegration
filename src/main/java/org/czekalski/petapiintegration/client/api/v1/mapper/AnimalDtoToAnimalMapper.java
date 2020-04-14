package org.czekalski.petapiintegration.client.api.v1.mapper;

import org.czekalski.petapiintegration.client.api.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.client.api.v1.dto.BreedsDto;
import org.czekalski.petapiintegration.server.model.Animal;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnimalDtoToAnimalMapper implements Mapper<AnimalDto, Animal> {
    @Override
    public Animal map(AnimalDto animalDto) {
        if (animalDto == null) {
            return null;
        } else {
            return new Animal.Builder()
                    .withId(animalDto.getId())
                    .withName(animalDto.getName())
                    .withBreed(
                            Optional.ofNullable(animalDto.getBreeds())
                                    .map(BreedsDto::getPrimary)
                                    .orElse(null)
                    )
                    .withAge(animalDto.getAge())
                    .withGender(animalDto.getGender()).build();
        }
    }
}
