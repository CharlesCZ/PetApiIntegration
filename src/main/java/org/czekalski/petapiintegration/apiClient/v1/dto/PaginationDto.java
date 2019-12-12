
package org.czekalski.petapiintegration.apiClient.v1.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

public class PaginationDto {


    private final Integer countPerPage;

    private final Integer totalCount;

    private final Integer currentPage;

    private final Integer totalPages;

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
    public PaginationDto(  @JsonProperty("count_per_page")Integer countPerPage,
                           @JsonProperty("total_count") Integer totalCount,
                           @JsonProperty("current_page")Integer currentPage,
                           @JsonProperty("total_pages") Integer totalPages) {
        this.countPerPage = countPerPage;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }


    public Integer getCountPerPage() {
        return countPerPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }
}
