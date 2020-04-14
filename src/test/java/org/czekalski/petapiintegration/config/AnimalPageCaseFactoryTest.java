package org.czekalski.petapiintegration.config;

import org.czekalski.petapiintegration.client.api.v1.dto.AnimalsListDto;
import org.czekalski.petapiintegration.client.api.v1.dto.PaginationDto;
import org.czekalski.petapiintegration.infrastructure.factory.animal.AnimalPageCaseFactory;
import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourcesListDto;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;
import org.springframework.hateoas.EntityModel;

import java.util.Collections;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnimalPageCaseFactoryTest {

    private final AnimalPageCaseFactory animalPageCaseFactory = new AnimalPageCaseFactory();
    private static final String CITY_ID = "Andover";
    private static final String STATE_ID = "MA";


    @Test
    void AddLinksToFirstPage() {
        //given
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

        //when
        EntityModel<AnimalResourcesListDto> animalResourcesListDtoEntityModel = animalPageCaseFactory
                .toModel(
                        animalResourcesListDto,
                        STATE_ID,
                        CITY_ID);

        //then
        assertThat(animalResourcesListDtoEntityModel.getLink("prev").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=1");
        assertThat(animalResourcesListDtoEntityModel.getLink("self").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=1");
        assertThat(animalResourcesListDtoEntityModel.getLink("next").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=2");
    }


    @Test
    void AddLinksToMiddlePage() {
        //given
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

        //when
        EntityModel<AnimalResourcesListDto> animalResourcesListDtoEntityModel = animalPageCaseFactory
                .toModel(
                        animalResourcesListDto,
                        STATE_ID,
                        CITY_ID);

        //when
        assertThat(animalResourcesListDtoEntityModel.getLink("prev").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=2");
        assertThat(animalResourcesListDtoEntityModel.getLink("self").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=3");
        assertThat(animalResourcesListDtoEntityModel.getLink("next").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=4");
    }

    @Test
    void AddLinksToLastPage() {
        //given
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

        //when
        EntityModel<AnimalResourcesListDto> animalResourcesListDtoEntityModel = animalPageCaseFactory
                .toModel(
                        animalResourcesListDto,
                        STATE_ID,
                        CITY_ID);

        //then
        assertThat(animalResourcesListDtoEntityModel.getLink("prev").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=127");
        assertThat(animalResourcesListDtoEntityModel.getLink("self").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=128");
    }

    @Test
    void AddLinksAfterAllPages() {
        //given
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

        //when
        EntityModel<AnimalResourcesListDto> animalResourcesListDtoEntityModel = animalPageCaseFactory
                .toModel(
                        animalResourcesListDto,
                        STATE_ID,
                        CITY_ID);

        //then
        assertThat(animalResourcesListDtoEntityModel.getLink("prev").get().getHref())
                .isEqualTo("/dogs/MA/Andover?size=1&page=128");
        assertThrows(
                NoSuchElementException.class,
                animalResourcesListDtoEntityModel.getLink("self")::get);
    }
}