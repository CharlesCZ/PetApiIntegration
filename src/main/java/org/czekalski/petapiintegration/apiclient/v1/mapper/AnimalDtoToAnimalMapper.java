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
            return new Animal.AnimalBuilder()
                    .setId(animalDto.getId())
                    .setName(animalDto.getName())
                    .setBreed(
                            this.breedDtoToBreed(animalDto.getBreeds())
                    )
                    .setAge(animalDto.getAge())
                    .setGender(animalDto.getGender()).build();
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
