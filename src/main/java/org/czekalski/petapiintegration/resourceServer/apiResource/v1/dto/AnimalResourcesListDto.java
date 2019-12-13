package org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AnimalResourcesListDto {
    private final List<AnimalResourceDto> content;

    private final PaginationResourceDto pagination;

    @JsonCreator
    public AnimalResourcesListDto(
            @JsonProperty("content") List<AnimalResourceDto> content,
            @JsonProperty("pagination") PaginationResourceDto pagination) {
        this.content = content;
        this.pagination = pagination;
    }


    public List<AnimalResourceDto> getContent() {
        return content;
    }

    public PaginationResourceDto getPagination() {
        return pagination;
    }
}
