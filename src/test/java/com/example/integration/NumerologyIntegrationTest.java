package com.example.integration;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional  // erases any effects of the test on the database
public class NumerologyIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createsProfileAndReturnsCorrectData() {
        String url = "http://localhost:" + port + "/api/profile";

        UserDto user = new UserDto("Marian", "Filip", 1991, 4, 27);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserDto> request = new HttpEntity<>(user, headers);

        ResponseEntity<NumerologyProfileResponse> response =
                restTemplate.postForEntity(url, request, NumerologyProfileResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode(), "HTTP Status Code 200 is OK");
        assertNotNull(response.getBody(), "Answer must contain a body");

        NumerologyProfileResponse profile = response.getBody();
        assertNotNull(profile, "Returned profile must not be null");

        assertAll("Checks on numerological values",
                () -> assertEquals("Marian", profile.firstName()),
                () -> assertEquals("Filip", profile.lastName()),
                () -> assertEquals(6, profile.destinyNumber()),
                () -> assertEquals(11, profile.soulUrgeNumber()),
                () -> assertEquals(7, profile.personalityNumber()),
                () -> assertEquals(9, profile.expressionNumber()),
                () -> assertEquals(6, profile.maturityNumber())
        );
    }
}