package org.czekalski.petapiintegration.client.api.v1.mapper;

import org.czekalski.petapiintegration.client.api.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.client.api.v1.dto.BreedsDto;
import org.czekalski.petapiintegration.server.model.Animal;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Supplier;

@Component
public class AnimalDtoToAnimalMapper implements Mapper<AnimalDto, Animal> {
    @Override
    public Animal map(AnimalDto animalDto) {
        return Optional.ofNullable(animalDto)
                .map(aDto -> new Animal.Builder()
                        .withId(aDto.getId())
                        .withName(aDto.getName())
                    .withBreed(
                            Optional.ofNullable(aDto.getBreeds())
                                    .map(BreedsDto::getPrimary)
                                    .orElse(null)
                    )
                        .withAge(aDto.getAge())
                        .withGender(aDto.getGender()).build())
                .orElse(null);
    }
}
