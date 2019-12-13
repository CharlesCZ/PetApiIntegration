package org.czekalski.petapiintegration.apiClient.v1.mapper;

import org.czekalski.petapiintegration.apiClient.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.resourceServer.model.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalDtoToAnimal implements Mapper<AnimalDto, Animal> {
    @Override
    public Animal map(AnimalDto animalDto) {
        if (animalDto == null) {
            return null;
        } else {
            Animal animal = new Animal();
            animal.setId(animalDto.getId());
            animal.setName(animalDto.getName());
            animal.setBreed(animalDto.getBreeds().getPrimary());
            animal.setAge(animalDto.getAge());
            animal.setGender(animalDto.getGender());
            return animal;
        }
    }
}
