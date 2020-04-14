package org.czekalski.petapiintegration.client.api.v1.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginationDto that = (PaginationDto) o;
        return countPerPage == that.countPerPage &&
                totalCount == that.totalCount &&
                currentPage == that.currentPage &&
                totalPages == that.totalPages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countPerPage, totalCount, currentPage, totalPages);
    }
}
