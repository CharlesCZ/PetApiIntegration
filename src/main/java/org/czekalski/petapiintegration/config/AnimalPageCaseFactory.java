package org.czekalski.petapiintegration.config;

import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceserver.controller.AnimalController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AnimalPageCaseFactory {

    interface PaginationCase {
        EntityModel<AnimalResourcesListDto> calculateCase(
                AnimalResourcesListDto animalResourcesListDto,
                String stateId,
                String cityId,
                int page);
    }

    private class LastPage implements PaginationCase {
        @Override
        public EntityModel<AnimalResourcesListDto> calculateCase(
                AnimalResourcesListDto animalResourcesListDto,
                String stateId,
                String cityId,
                int page) {
            int size= animalResourcesListDto.getPagination().getSize();

            return new EntityModel<>(animalResourcesListDto,
                    WebMvcLinkBuilder.linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page - 1)).withRel("prev"),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel());
        }
    }

    private class MiddlePage implements PaginationCase {
        @Override
        public EntityModel<AnimalResourcesListDto> calculateCase(
                AnimalResourcesListDto animalResourcesListDto,
                String stateId,
                String cityId,
                int page) {
            int size= animalResourcesListDto.getPagination().getSize();

            return new EntityModel<>(animalResourcesListDto,
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page - 1)).withRel("prev"),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel(),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page + 1)).withRel("next"));
        }
    }

    private class FirstPage implements PaginationCase {
        @Override
        public EntityModel<AnimalResourcesListDto> calculateCase(
                AnimalResourcesListDto animalResourcesListDto,
                String stateId,
                String cityId,
                int page) {
            int size= animalResourcesListDto.getPagination().getSize();

            return new EntityModel<>(animalResourcesListDto,
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withRel("prev"),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel(),
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page + 1)).withRel("next"));
        }
    }

    private class AfterAllPages implements PaginationCase {

        @Override
        public EntityModel<AnimalResourcesListDto> calculateCase(
                AnimalResourcesListDto animalResourcesListDto,
                String stateId,
                String cityId,
                int page) {
            int size= animalResourcesListDto.getPagination().getSize();

            return new EntityModel<>(animalResourcesListDto,
                    WebMvcLinkBuilder.linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, animalResourcesListDto.getPagination().getTotalPages())).withRel("prev"));
        }

    }


    private class UnspecifiedPage implements PaginationCase {
        @Override
        public EntityModel<AnimalResourcesListDto> calculateCase(
                AnimalResourcesListDto animalResourcesListDto,
                String stateId,
                String cityId,
                int page) {
            int size= animalResourcesListDto.getPagination().getSize();

            return new EntityModel<>(animalResourcesListDto,
                    linkTo(methodOn(AnimalController.class).getDogsFromCity(stateId, cityId, size, page)).withSelfRel());
        }
    }

    public EntityModel<AnimalResourcesListDto> toModel(
            AnimalResourcesListDto animalResourcesListDto,
            String stateId,
            String cityId) {

        int currentPage = animalResourcesListDto.getPagination().getPageable().getPageNumber();
        int totalPages = animalResourcesListDto.getPagination().getTotalPages();
        if (currentPage > 1 && currentPage == totalPages) {
            return new LastPage().calculateCase(animalResourcesListDto, stateId, cityId, currentPage);
        } else if (currentPage > 1 && currentPage > totalPages) {
            return new AfterAllPages().calculateCase(animalResourcesListDto, stateId, cityId, currentPage);
        } else if (currentPage > 1 && currentPage < totalPages) {
            return new MiddlePage().calculateCase(animalResourcesListDto, stateId, cityId, currentPage);
        } else if (currentPage == 1 && totalPages > 1) { //always exists at least 2 pages inside PageImpl
            return new FirstPage().calculateCase(animalResourcesListDto, stateId, cityId, currentPage);
        } else {
            return new UnspecifiedPage().calculateCase(animalResourcesListDto, stateId, cityId, currentPage);
        }
    }
}

