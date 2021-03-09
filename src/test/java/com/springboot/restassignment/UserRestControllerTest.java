package com.springboot.restassignment;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void allUsersTestSuccess() throws Exception {
        this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"userName\" : \"user1\"")));
    }

    @Test
    void usersByIdTest() throws Exception {
        this.mockMvc.perform(get("/users/1234567")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"userName\" : \"user1\"")));
    }

    @Test
    void allUsersTestFailure() throws Exception {
        this.mockMvc.perform(get("/users/0")).andDo(print()).andExpect(status().is4xxClientError());
    }


}
