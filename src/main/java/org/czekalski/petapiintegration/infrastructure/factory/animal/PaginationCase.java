package org.czekalski.petapiintegration.infrastructure.factory.animal;

import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourcesListDto;
import org.springframework.hateoas.EntityModel;

interface PaginationCase {
    EntityModel<AnimalResourcesListDto> calculateCase();
}