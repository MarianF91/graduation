package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.service.NumerologyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfileControllerTest {

    @Mock
    private NumerologyService numerologyService;

    private ProfileController profileController;

    @BeforeEach
    void setUp() {
        profileController = new ProfileController(numerologyService);
    }

    @Test
    void testCreateProfile() {
        // arrange
        UserDto dto = new UserDto("Marian", "Filip", 1991, 4, 27);
        NumerologyProfileResponse expectedResponse = new NumerologyProfileResponse();
        when(numerologyService.calculateProfile(dto)).thenReturn(expectedResponse);

        // act
        ResponseEntity<NumerologyProfileResponse> response = profileController.create(dto);

        // assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(numerologyService, times(1)).calculateProfile(dto);
    }

    @Test
    void testFindProfile() {
        // arrange
        Long id = 1L;
        NumerologyProfileResponse expectedProfile = new NumerologyProfileResponse();
        when(numerologyService.findProfile(id)).thenReturn(expectedProfile);

        // act
        ResponseEntity<NumerologyProfileResponse> response = profileController.find(id);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedProfile, response.getBody());
        verify(numerologyService, times(1)).findProfile(id);
    }

    @Test
    void testFindAllProfiles() {
        // arrange
        when(numerologyService.findAllProfiles()).thenReturn(Collections.emptyList());

        // act
        var response = profileController.findAll();

        // assert
        assertNotNull(response);
        assertTrue(response.isEmpty());
        verify(numerologyService, times(1)).findAllProfiles();
    }
}