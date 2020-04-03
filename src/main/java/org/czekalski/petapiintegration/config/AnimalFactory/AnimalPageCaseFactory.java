package org.czekalski.petapiintegration.config.AnimalFactory;

import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class AnimalPageCaseFactory {


    private PaginationCase paginationFactory(AnimalResourcesListDto animalResourcesListDto, String stateId, String cityId) {
        int currentPage = animalResourcesListDto.getPagination().getPageable().getPageNumber();
        int totalPages = animalResourcesListDto.getPagination().getTotalPages();
        if (currentPage > 1 && currentPage == totalPages) {
            return new LastPage(animalResourcesListDto, stateId, cityId);
        } else if (currentPage > 1 && currentPage > totalPages) {
            return new AfterAllPages(animalResourcesListDto, stateId, cityId);
        } else if (currentPage > 1 && currentPage < totalPages) {
            return new MiddlePage(animalResourcesListDto, stateId, cityId);
        } else if (currentPage == 1 && totalPages > 1) { //always exists at least 2 pages inside PageImpl
            return new FirstPage(animalResourcesListDto, stateId, cityId);
        } else
            throw new NoSuchElementException();

    }


    public EntityModel<AnimalResourcesListDto> toModel(
            AnimalResourcesListDto animalResourcesListDto,
            String stateId,
            String cityId) {

        return paginationFactory(animalResourcesListDto, stateId, cityId).calculateCase();

    }
}

