package org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.List;

public class AnimalResourcesListDto {
    private final Page<AnimalResourceDto> pagination;

    @JsonCreator
    public AnimalResourcesListDto(
            @JsonProperty("pagination") Page<AnimalResourceDto> pagination) {
        this.pagination = pagination;
    }

    public Page<AnimalResourceDto> getPagination() {
        return pagination;
    }
}
