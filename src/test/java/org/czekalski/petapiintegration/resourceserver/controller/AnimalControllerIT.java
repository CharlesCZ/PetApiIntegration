package org.czekalski.petapiintegration.resourceserver.controller;

import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceserver.service.AnimalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
@WebMvcTest(AnimalController.class)
class AnimalControllerIT {
    private static final String BREED = "Labrador Retriever";
    private static final String AGE = "Adult";
    private static final String GENDER = "Female";
    private static final int ID = 1;
    private static final String NAME = "Reksia";
    private static final int COUNT_PER_PAGE = 10;
    private static final int TOTAL_COUNT = 3000;
    private static final int CURRENT_PAGE = 1;
    private static final int TOTAL_PAGES = 300;
    private static final String CITY_ID = "Andover";
    private static final String STATE_ID = "MA";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AnimalService animalService;


    @WithMockUser(username = "doglover", password = "hardpassword1234", roles = "ADMIN")
    @Test
    void getDogsFromCity() throws Exception {
        //given
        AnimalResourcesListDto animalResourcesListDto = new AnimalResourcesListDto(
                Collections.singletonList(new AnimalResourceDto(ID, NAME, BREED, AGE, GENDER)), new PaginationResourceDto(COUNT_PER_PAGE, TOTAL_COUNT, CURRENT_PAGE, TOTAL_PAGES));

        given(animalService.findDogsByCityIdAndDogsQuantity(anyString(), anyString(), anyInt())).willReturn(animalResourcesListDto);

        //when then
        mockMvc.perform(get("/dogs" + "/" + CITY_ID + "/" + STATE_ID)
                .param("size", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.pagination.total_count", is(TOTAL_COUNT)))
                .andExpect(jsonPath("$.length()", is(2)))
                .andDo(print());


        then(animalService).should().findDogsByCityIdAndDogsQuantity(anyString(), anyString(), anyInt());
    }
}*/