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
public class ClaimsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void allClaimsTestSuccess() throws Exception {
        this.mockMvc.perform(get("/claims")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"claimId\" : 1")));
    }

    @Test
    void claimsByIdTest() throws Exception {
        this.mockMvc.perform(get("/claims/5")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("\"claimId\" : 1")));
    }

    @Test
    void allClaimsTestFailure() throws Exception {
        this.mockMvc.perform(get("/claims/0")).andDo(print()).andExpect(status().is4xxClientError());
    }


}
