package org.czekalski.petapiintegration.server.api.resource.v1.mapper;

import org.czekalski.petapiintegration.client.api.v1.mapper.Mapper;
import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.server.model.Animal;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnimalToAnimalResourceDtoMapper implements Mapper<Animal, AnimalResourceDto> {
    @Override
    public AnimalResourceDto map(Animal animal) {
        return Optional.ofNullable(animal)
                .map(mappedAnimal -> new AnimalResourceDto(
                        mappedAnimal.getId(),
                        mappedAnimal.getName(),
                        mappedAnimal.getBreed(),
                        mappedAnimal.getAge(),
                        mappedAnimal.getGender()))
                .orElse(null);
    }
}
