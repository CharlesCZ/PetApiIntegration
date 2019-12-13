
package org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginationResourceDto {
    private final Integer countPerPage;

    private final Integer totalCount;

    private final Integer currentPage;

    private final Integer totalPages;

    @JsonCreator
    public PaginationResourceDto(
            @JsonProperty("count_per_page") Integer countPerPage,
            @JsonProperty("total_count") Integer totalCount,
            @JsonProperty("current_page") Integer currentPage,
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
