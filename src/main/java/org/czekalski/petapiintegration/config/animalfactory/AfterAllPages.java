package org.czekalski.petapiintegration.config.animalfactory;

import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceserver.controller.AnimalController;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

final class AfterAllPages implements PaginationCase {
    private final AnimalResourcesListDto animalResourcesListDto;
    private final String stateId;
    private final String cityId;

    AfterAllPages(AnimalResourcesListDto animalResourcesListDto, String stateId, String cityId) {
        this.animalResourcesListDto = animalResourcesListDto;
        this.stateId = stateId;
        this.cityId = cityId;
    }

    @Override
    public EntityModel<AnimalResourcesListDto> calculateCase() {
        int size = animalResourcesListDto.getPagination().getSize();

        return new EntityModel<>(animalResourcesListDto,
                linkTo(
                        methodOn(AnimalController.class)
                                .getDogsFromCity(stateId, cityId, size, animalResourcesListDto.getPagination().getTotalPages()))
                        .withRel("prev"));
    }

}