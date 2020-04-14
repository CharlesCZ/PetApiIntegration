package org.czekalski.petapiintegration.client.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

public class AnimalsListDto {
    private final List<AnimalDto> animals;

    private final PaginationDto pagination;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalsListDto that = (AnimalsListDto) o;
        return Objects.equals(animals, that.animals) &&
                Objects.equals(pagination, that.pagination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animals, pagination);
    }
}
