package org.czekalski.petapiintegration.apiClient.v1.mapper;

import org.czekalski.petapiintegration.apiClient.v1.dto.PaginationDto;
import org.czekalski.petapiintegration.resourceServer.model.Pagination;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaginationDtoToPaginationTest {
    private static final int COUNT_PER_PAGE = 10;
    private static final int TOTAL_COUNT = 3000;
    private static final int CURRENT_PAGE = 1;
    private static final int TOTAL_PAGES = 300;
    private final Mapper<PaginationDto, Pagination> paginationDtoToPagination = new PaginationDtoToPagination();

    @Test
    void map() {
        //given
        PaginationDto paginationDto = new PaginationDto(COUNT_PER_PAGE, TOTAL_COUNT, CURRENT_PAGE, TOTAL_PAGES);

        //when
        Pagination pagination = paginationDtoToPagination.map(paginationDto);

        //then
        assertEquals(COUNT_PER_PAGE, pagination.getCountPerPage());
        assertEquals(TOTAL_COUNT, pagination.getTotalCount());
        assertEquals(CURRENT_PAGE, pagination.getCurrentPage());
        assertEquals(TOTAL_PAGES, pagination.getTotalPages());
    }
}