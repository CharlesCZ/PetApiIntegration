package org.czekalski.petapiintegration.apiClient.v1.dto;

import com.fasterxml.jackson.annotation.*;

public class PaginationDto {
    private final int countPerPage;

    private final int totalCount;

    private final int currentPage;

    private final int totalPages;

    @JsonCreator
    public PaginationDto(
            @JsonProperty("count_per_page") int countPerPage,
            @JsonProperty("total_count") int totalCount,
            @JsonProperty("current_page") int currentPage,
            @JsonProperty("total_pages") int totalPages) {
        this.countPerPage = countPerPage;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }


    public int getCountPerPage() {
        return countPerPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
