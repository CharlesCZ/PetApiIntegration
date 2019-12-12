package org.czekalski.petapiintegration.apiClient.v1.dto;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AnimalsListDto {
    private final   List<AnimalDto> animals;

    private final  PaginationDto pagination;



    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonCreator
    public AnimalsListDto(  @JsonProperty("animals")List<AnimalDto> animals,
                            @JsonProperty("pagination")PaginationDto pagination) {
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
