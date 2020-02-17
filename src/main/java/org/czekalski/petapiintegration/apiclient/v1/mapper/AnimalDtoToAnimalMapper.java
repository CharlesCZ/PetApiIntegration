package org.czekalski.petapiintegration.apiclient.v1.mapper;

import org.czekalski.petapiintegration.apiclient.v1.dto.AnimalDto;
import org.czekalski.petapiintegration.apiclient.v1.dto.BreedsDto;
import org.czekalski.petapiintegration.resourceserver.model.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalDtoToAnimalMapper implements Mapper<AnimalDto, Animal> {
    @Override
    public Animal map(AnimalDto animalDto) {
        if (animalDto == null) {
            return null;
        } else {
            Animal animal = new Animal();
            animal.setId(animalDto.getId());
            animal.setName(animalDto.getName());
            animal.setBreed(this.breedDtoToBreed(animalDto.getBreeds()));
            animal.setAge(animalDto.getAge());
            animal.setGender(animalDto.getGender());
            return animal;
        }
    }

    private String breedDtoToBreed(BreedsDto breedsDto) {
        if (breedsDto == null) {
            return null;
        } else {
            return breedsDto.getPrimary();
        }
    }
}
