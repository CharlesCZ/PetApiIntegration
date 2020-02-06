package org.czekalski.petapiintegration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
    public static final int PAGE_NUMBER = 1;

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
        mockMvc.perform(get("/dogs" + "/" + STATE_ID+"/"+ CITY_ID)
                .param("size", "2")
                .param("page", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pagination.content", hasSize(2)))
                .andExpect(jsonPath("$.pagination.size", is(COUNT_PER_PAGE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pagination.number", is(PAGE_NUMBER)))
                .andDo(print());
    }

}
