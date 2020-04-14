package org.czekalski.petapiintegration.infrastructure.factory.animal;

import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.server.controller.AnimalController;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

final class LastPage implements PaginationCase {
    private final AnimalResourcesListDto animalResourcesListDto;
    private final String stateId;
    private final String cityId;

    LastPage(AnimalResourcesListDto animalResourcesListDto, String stateId, String cityId) {
        this.animalResourcesListDto = animalResourcesListDto;
        this.stateId = stateId;
        this.cityId = cityId;
    }

    @Override
    public EntityModel<AnimalResourcesListDto> calculateCase() {
        final int size = animalResourcesListDto.getPagination().getSize();
        final int currentPage = animalResourcesListDto.getPagination().getPageable().getPageNumber();

        return new EntityModel<>(animalResourcesListDto,
                linkTo(methodOn(AnimalController.class)
                        .getDogsFromCity(stateId, cityId, size, currentPage - 1)).withRel("prev"),
                linkTo(methodOn(AnimalController.class)
                        .getDogsFromCity(stateId, cityId, size, currentPage)).withSelfRel());
    }
}
