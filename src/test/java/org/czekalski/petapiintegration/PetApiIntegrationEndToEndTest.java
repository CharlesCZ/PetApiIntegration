package org.czekalski.petapiintegration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PetApiIntegrationEndToEndTest {
    private static final int COUNT_PER_PAGE = 2;
    private static final String CITY_ID = "Andover";
    private static final String STATE_ID = "MA";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @WithMockUser(username = "doglover", password = "hardpassword1234", roles = "ADMIN")
    @Test
    void getDogsFromCity() throws Exception {

        //when then
        mockMvc.perform(get("/dogs" + "/" + CITY_ID + "/" + STATE_ID)
                .param("size", "2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.pagination.count_per_page", is(COUNT_PER_PAGE)))
                .andExpect(jsonPath("$.length()", is(2)))
                .andDo(print());
    }

}
