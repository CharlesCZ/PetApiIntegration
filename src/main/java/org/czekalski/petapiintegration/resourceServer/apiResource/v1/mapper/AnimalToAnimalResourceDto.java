package org.czekalski.petapiintegration.resourceServer.apiResource.v1.mapper;

import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceServer.model.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalToAnimalResourceDto implements Mapper<Animal, AnimalResourceDto> {
    @Override
    public AnimalResourceDto map(Animal animal) {
        if (animal == null) {
            return null;
        } else {
            return new AnimalResourceDto(animal.getId(), animal.getName(), animal.getBreed(), animal.getAge(), animal.getGender());
        }
    }
}
