package org.czekalski.petapiintegration;


import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourceDto;
import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;
import org.czekalski.petapiintegration.resourceserver.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.hateoas.MediaTypes;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PetApiIntegrationEndToEndTest {
    private static final int COUNT_PER_PAGE = 2;
    private static final String CITY_ID = "Andover";
    private static final String STATE_ID = "MA";
    private static final int PAGE_NUMBER = 1;
    private static final int TOTAL_COUNT = 3000;

    @MockBean
    AnimalService animalService;

    @Autowired
    private MockMvc mockMvc;


    @WithMockUser(username = "doglover", password = "hardpassword1234", roles = "ADMIN")
    @Test
    void getDogsFromCity() throws Exception {
        //given
        Pageable pageable=PageRequest.of(PAGE_NUMBER, COUNT_PER_PAGE, Sort.Direction.ASC,"publishedAt");
        List<AnimalResourceDto> animalResourceDto=Arrays.asList(
                new AnimalResourceDto(0,"","","",""),
                new AnimalResourceDto(0,"","","",""));
        Page<AnimalResourceDto> page=new PageImpl<>(animalResourceDto,pageable,TOTAL_COUNT);
        AnimalResourcesListDto animalResourcesListDto = new AnimalResourcesListDto(page);



        //when then
        given(animalService.findDogsByCityIdAndStateId(anyString(), anyString(), anyInt(), anyInt()))
                .willReturn(animalResourcesListDto);

        mockMvc.perform(get("/dogs" + "/" + STATE_ID + "/" + CITY_ID).accept(MediaTypes.HAL_JSON_VALUE)
                .param("size", "2")
                .param("page", "1")
                .contentType(MediaTypes.HAL_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pagination.content", hasSize(2)))
                .andExpect(jsonPath("$.pagination.size", is(COUNT_PER_PAGE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pagination.number", is(PAGE_NUMBER)))
                .andExpect(jsonPath("$._links.self.href", is("http://localhost/dogs/MA/Andover?size=2&page=1")))
                .andDo(print());
    }

}
