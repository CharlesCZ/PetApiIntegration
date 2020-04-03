package org.czekalski.petapiintegration.config.AnimalFactory;

import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.springframework.hateoas.EntityModel;

interface PaginationCase {
    EntityModel<AnimalResourcesListDto> calculateCase();
}