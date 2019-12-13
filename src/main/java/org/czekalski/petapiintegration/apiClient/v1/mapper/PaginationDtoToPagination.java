package org.czekalski.petapiintegration.apiClient.v1.mapper;

import org.czekalski.petapiintegration.apiClient.v1.dto.PaginationDto;
import org.czekalski.petapiintegration.resourceServer.model.Pagination;
import org.springframework.stereotype.Component;

@Component
public class PaginationDtoToPagination implements Mapper<PaginationDto, Pagination> {
    @Override
    public Pagination map(PaginationDto paginationDto) {
        if (paginationDto == null) {
            return null;
        } else {
            Pagination pagination = new Pagination();
            pagination.setCountPerPage(paginationDto.getCountPerPage());
            pagination.setTotalCount(paginationDto.getTotalCount());
            pagination.setCurrentPage(paginationDto.getCurrentPage());
            pagination.setTotalPages(paginationDto.getTotalPages());
            return pagination;
        }
    }
}
