package org.czekalski.petapiintegration.resourceServer.apiResource.v1.mapper;

import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.PaginationResourceDto;
import org.czekalski.petapiintegration.resourceServer.model.Pagination;
import org.springframework.stereotype.Component;

@Component
public class PaginationToPaginationResource implements Mapper<Pagination, PaginationResourceDto> {
    @Override
    public PaginationResourceDto map(Pagination pagination) {
        if (pagination == null) {
            return null;
        } else {
            return new PaginationResourceDto(
                    pagination.getCountPerPage(), pagination.getTotalCount(), pagination.getCurrentPage(), pagination.getTotalPages());
        }
    }
}
