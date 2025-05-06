package com.example.integration;

import com.example.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NumerologyIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void createsProfileAndReturnsCorrectData() throws Exception {
        // given
        UserDto dto = new UserDto("Marian", "Filip", 1991, 4, 27);
        String json = mapper.writeValueAsString(dto);

        // when/then
        mvc.perform(post("/api/profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                // basic sanity checks on JSON body:
                .andExpect(jsonPath("$.firstName").value("Marian"))
                .andExpect(jsonPath("$.lastName").value("Filip"))
                .andExpect(jsonPath("$.destiny.number").value(9))
                .andExpect(jsonPath("$.soulUrge.number").value(11))
                .andExpect(jsonPath("$.personality.number").value(7))
                .andExpect(jsonPath("$.expression.number").value(9))
                .andExpect(jsonPath("$.maturity.number").value(6));
    }
}
