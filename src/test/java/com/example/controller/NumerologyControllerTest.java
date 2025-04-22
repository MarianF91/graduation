package com.example.controller;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.ProfileDto;
import com.example.dto.UserDto;
import com.example.model.MeaningType;
import com.example.service.MeaningService;
import com.example.service.NumerologyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumerologyControllerUnitTest {

    @Mock
    private NumerologyService numerologyService;
    @Mock
    private MeaningService meaningService;

    @InjectMocks
    private NumerologyController controller;

    @Test
    void createProfile_returnsExpected() {
        var dto = new UserDto("Marian","Filip",1991,4,27);
        var profile = new NumerologyProfileResponse(
                1L,
                new ProfileDto(6, "M6"),
                new ProfileDto(11,"M11"),
                new ProfileDto(7,"M7"),
                new ProfileDto(9,"M9"),
                new ProfileDto(6,"M6b"),
                "Marian","Filip"
        );
        when(numerologyService.generateAndSaveProfile(dto)).thenReturn(profile);

        ResponseEntity<NumerologyProfileResponse> resp = controller.create(dto);

        assertEquals(200, resp.getStatusCode().value());
        assertEquals(6, Objects.requireNonNull(resp.getBody()).destiny().number());
        verify(numerologyService).generateAndSaveProfile(dto);
    }

    @Test
    void getMeaning_returnsProfileDto() {
        when(meaningService.getMeaning(6, MeaningType.DESTINY)).thenReturn("Balanced");

        ResponseEntity<ProfileDto> resp = controller.getMeaning(6, MeaningType.DESTINY);

        assertEquals(200, resp.getStatusCode().value());
        assertEquals(6, Objects.requireNonNull(resp.getBody()).number());
        assertEquals("Balanced", resp.getBody().meaning());
        verify(meaningService).getMeaning(6, MeaningType.DESTINY);
    }
}