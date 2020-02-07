package org.czekalski.petapiintegration.config;

import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceserver.controller.AnimalController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


public class AnimalRepresentationModelAssembler {


    public EntityModel<AnimalResourcesListDto> toModel(AnimalResourcesListDto animalResourcesListDto, String stateId, String cityId, int size, int page) {

        if (page == animalResourcesListDto.getPagination().getTotalPages()) {
            return new EntityModel<>(animalResourcesListDto,
                    WebMvcLinkBuilder.linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page - 1)).withRel("prev"),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel(),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withRel("next"));
        } else if (page > 1 && page < animalResourcesListDto.getPagination().getTotalPages()) {
            return new EntityModel<>(animalResourcesListDto,
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page - 1)).withRel("prev"),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel(),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page + 1)).withRel("next"));
        } else if (page == 1 && animalResourcesListDto.getPagination().getTotalPages() == 1) {
            return new EntityModel<>(animalResourcesListDto,
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withRel("prev"),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel(),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withRel("next"));
        } else if (page == 1 && animalResourcesListDto.getPagination().getTotalPages() > 1) {
            return new EntityModel<>(animalResourcesListDto,
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withRel("prev"),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel(),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page + 1)).withRel("next"));
        } else {
            return new EntityModel<>(animalResourcesListDto,
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel());
        }
    }
}
