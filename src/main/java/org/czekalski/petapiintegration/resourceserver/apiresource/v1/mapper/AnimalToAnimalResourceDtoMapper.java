package org.czekalski.petapiintegration.resourceserver.apiresource.v1.mapper;

import org.czekalski.petapiintegration.apiclient.v1.mapper.Mapper;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceserver.model.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalToAnimalResourceDtoMapper implements Mapper<Animal, AnimalResourceDto> {
    @Override
    public AnimalResourceDto map(Animal animal) {
        if (animal == null) {
            return null;
        } else {
            return new AnimalResourceDto(
                    animal.getId(),
                    animal.getName(),
                    animal.getBreed(),
                    animal.getAge(),
                    animal.getGender());
        }
    }
}
