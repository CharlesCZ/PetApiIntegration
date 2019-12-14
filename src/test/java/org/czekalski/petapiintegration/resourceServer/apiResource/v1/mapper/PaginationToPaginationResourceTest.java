package org.czekalski.petapiintegration.resourceServer.apiResource.v1.mapper;

import org.czekalski.petapiintegration.apiClient.v1.mapper.Mapper;
import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.PaginationResourceDto;
import org.czekalski.petapiintegration.resourceServer.model.Pagination;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaginationToPaginationResourceTest {
    private static final int COUNT_PER_PAGE = 10;
    private static final int TOTAL_COUNT = 3000;
    private static final int CURRENT_PAGE = 1;
    private static final int TOTAL_PAGES = 300;
    private final Mapper<Pagination, PaginationResourceDto> paginationToPaginationResourceDto = new PaginationToPaginationResource();

    @Test
    void paginationToPaginationResource() {
        //when
        Pagination pagination = new Pagination(COUNT_PER_PAGE, TOTAL_COUNT, CURRENT_PAGE, TOTAL_PAGES);

        //when
        PaginationResourceDto paginationResourceDto = paginationToPaginationResourceDto.map(pagination);

        //then
        assertEquals(COUNT_PER_PAGE, paginationResourceDto.getCountPerPage());
        assertEquals(TOTAL_COUNT, paginationResourceDto.getTotalCount());
        assertEquals(CURRENT_PAGE, paginationResourceDto.getCurrentPage());
        assertEquals(TOTAL_PAGES, paginationResourceDto.getTotalPages());
    }
}