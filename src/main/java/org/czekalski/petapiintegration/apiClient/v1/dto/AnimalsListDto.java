package org.czekalski.petapiintegration.apiClient.v1.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class AnimalsListDto {
    private final List<AnimalDto> animals;

    private final  PaginationDto pagination;

    @JsonCreator
    public AnimalsListDto(
            @JsonProperty("animals") List<AnimalDto> animals,
            @JsonProperty("pagination") PaginationDto pagination) {
        this.animals = animals;
        this.pagination = pagination;
    }

    public List<AnimalDto> getAnimals() {
        return animals;
    }

    public PaginationDto getPagination() {
        return pagination;
    }
}
