package org.czekalski.petapiintegration.config;

import org.czekalski.petapiintegration.apiclient.v1.dto.AnimalsListDto;
import org.czekalski.petapiintegration.apiclient.v1.dto.PaginationDto;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;
import org.springframework.hateoas.EntityModel;

import java.util.Collections;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

class AnimalPageCaseFactoryTest {

    private final AnimalPageCaseFactory animalPageCaseFactory = new AnimalPageCaseFactory();
    private static final String CITY_ID = "Andover";
    private static final String STATE_ID = "MA";


    @Test
    void AddLinksToFirstPage() {
        PaginationDto paginationDto = new PaginationDto(1, 128, 1, 128);
        AnimalsListDto animalsListDto = new AnimalsListDto(Collections.emptyList(), paginationDto);
        Pageable pageable = PageRequest.of(
                animalsListDto.getPagination().getCurrentPage(),
                animalsListDto.getPagination().getCountPerPage(),
                Sort.Direction.ASC,
                "publishedAt");
        AnimalResourcesListDto animalResourcesListDto = new AnimalResourcesListDto(
                new PageImpl<>(
                        Collections.singletonList(
                                new AnimalResourceDto(
                                        1,
                                        "",
                                        "",
                                        "",
                                        "")),
                        pageable,
                        128));

        EntityModel<AnimalResourcesListDto> animalResourcesListDtoEntityModel = animalPageCaseFactory
                .toModel(
                        animalResourcesListDto,
                        STATE_ID,
                        CITY_ID);
        assertThat(animalResourcesListDtoEntityModel.getLink("prev").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=1");
        assertThat(animalResourcesListDtoEntityModel.getLink("self").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=1");
        assertThat(animalResourcesListDtoEntityModel.getLink("next").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=2");
    }


    @Test
    void AddLinksToMiddlePage() {
        PaginationDto paginationDto = new PaginationDto(1, 128, 3, 128);
        AnimalsListDto animalsListDto = new AnimalsListDto(Collections.emptyList(), paginationDto);
        Pageable pageable = PageRequest.of(
                animalsListDto.getPagination().getCurrentPage(),
                animalsListDto.getPagination().getCountPerPage(),
                Sort.Direction.ASC,
                "publishedAt");
        AnimalResourcesListDto animalResourcesListDto = new AnimalResourcesListDto(
                new PageImpl<>(
                        Collections.singletonList(
                                new AnimalResourceDto(
                                        1,
                                       "",
                                        "",
                                        "",
                                        "")),
                        pageable,
                        128));

        EntityModel<AnimalResourcesListDto> animalResourcesListDtoEntityModel = animalPageCaseFactory
                .toModel(
                        animalResourcesListDto,
                        STATE_ID,
                        CITY_ID);
        assertThat(animalResourcesListDtoEntityModel.getLink("prev").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=2");
        assertThat(animalResourcesListDtoEntityModel.getLink("self").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=3");
        assertThat(animalResourcesListDtoEntityModel.getLink("next").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=4");
    }

    @Test
    void AddLinksToLastPage() {
        PaginationDto paginationDto = new PaginationDto(1, 128, 128, 128);
        AnimalsListDto animalsListDto = new AnimalsListDto(Collections.emptyList(), paginationDto);
        Pageable pageable = PageRequest.of(
                animalsListDto.getPagination().getCurrentPage(),
                animalsListDto.getPagination().getCountPerPage(),
                Sort.Direction.ASC,
                "publishedAt");

        Page<AnimalResourceDto> page = new PageImpl<>(
                Collections.emptyList(),
                pageable,
                128);
        AnimalResourcesListDto animalResourcesListDto = new AnimalResourcesListDto(page);
        System.out.println(page.getTotalPages());
        EntityModel<AnimalResourcesListDto> animalResourcesListDtoEntityModel = animalPageCaseFactory
                .toModel(
                        animalResourcesListDto,
                        STATE_ID,
                        CITY_ID);

        assertThat(animalResourcesListDtoEntityModel.getLink("prev").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=127");
        assertThat(animalResourcesListDtoEntityModel.getLink("self").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=128");
    }

    @Test
    void AddLinksAfterAllPages() {
        PaginationDto paginationDto = new PaginationDto(1, 128, 129, 128);
        AnimalsListDto animalsListDto = new AnimalsListDto(Collections.emptyList(), paginationDto);
        Pageable pageable = PageRequest.of(
                animalsListDto.getPagination().getCurrentPage(),
                animalsListDto.getPagination().getCountPerPage(),
                Sort.Direction.ASC,
                "publishedAt");
        AnimalResourcesListDto animalResourcesListDto = new AnimalResourcesListDto(
                new PageImpl<>(
                        Collections.emptyList(),
                        pageable,
                        128));

        EntityModel<AnimalResourcesListDto> animalResourcesListDtoEntityModel = animalPageCaseFactory
                .toModel(
                        animalResourcesListDto,
                        STATE_ID,
                        CITY_ID);
        assertThat(animalResourcesListDtoEntityModel.getLink("prev").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=128");

        assertThrows(
                NoSuchElementException.class,
                animalResourcesListDtoEntityModel.getLink("self")::get);
    }
}