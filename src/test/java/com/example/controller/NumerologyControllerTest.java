package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.model.MeaningType;
import com.example.service.MeaningService;
import com.example.service.NumerologyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NumerologyControllerTest {

    @Mock
    private NumerologyService numerologyService;

    @Mock
    private MeaningService meaningService;

    @InjectMocks
    private NumerologyController controller;

    private UserDto testDto;
    private NumerologyProfileResponse response;

    @BeforeEach
    void setUp() {
        testDto = new UserDto("Marian", "Filip", 1991, 4, 27);
        response = new NumerologyProfileResponse(
                1L,
                6, "You care about others, you are thoughtful and loyal.",
                11, "You are a visionary and deeply spiritual.",
                7, "You may be seen as deep, wise, and mysterious.",
                9, "You are generous, emotional, and dramatic in self-expression.",
                6, "You find fulfillment in service, family, and community.",
                "Marian",
                "Filip"
        );
    }

    @Test
    void createProfile_returnsExpectedResponse() {
        when(numerologyService.generateAndSaveProfile(testDto)).thenReturn(response);

        ResponseEntity<NumerologyProfileResponse> result = controller.create(testDto);

        assertEquals(200, result.getStatusCode().value());
        assertEquals(6, Objects.requireNonNull(result.getBody()).destinyNumber());
        verify(numerologyService).generateAndSaveProfile(testDto);
    }

    @Test
    void readProfileById_returnsProfile() {
        when(numerologyService.findProfile(1L)).thenReturn(response);

        ResponseEntity<NumerologyProfileResponse> result = controller.read(1L);

        assertEquals(200, result.getStatusCode().value());
        assertEquals("Filip", Objects.requireNonNull(result.getBody()).lastName());
    }

    @Test
    void getAllProfiles_returnsList() {
        when(numerologyService.findAllProfiles()).thenReturn(List.of(response));

        ResponseEntity<List<NumerologyProfileResponse>> result = controller.getAllProfiles();

        assertEquals(200, result.getStatusCode().value());
        assertEquals(1, Objects.requireNonNull(result.getBody()).size());
    }

    @Test
    void getMeaning_returnsExpectedText() {
        when(meaningService.getMeaning(6, MeaningType.DESTINY))
                .thenReturn("You are balanced and nurturing");

        ResponseEntity<String> result = controller.getMeaning(6, "DESTINY");

        assertEquals(200, result.getStatusCode().value());
        assertTrue(Objects.requireNonNull(result.getBody()).toLowerCase().contains("balanced"));
    }
}