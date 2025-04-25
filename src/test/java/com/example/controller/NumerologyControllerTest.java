package com.example.controller;

import com.example.dto.ProfileDto;
import com.example.model.MeaningType;
import com.example.service.MeaningService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumerologyControllerTest {

    @Mock private MeaningService meaningService;
    @InjectMocks private NumerologyController controller;

    @Test
    void getMeaning_returnsProfileDto() {
        int number = 6;
        MeaningType type = MeaningType.LIFE_PATH;
        when(meaningService.getMeaning(number, type)).thenReturn("Balanced");

        ResponseEntity<ProfileDto> resp = controller.getMeaning(number, type);

        assertEquals(200, resp.getStatusCode().value());
        ProfileDto body = resp.getBody();
        assertNotNull(body);
        assertEquals(6, body.number());
        assertEquals("Balanced", body.meaning());
        verify(meaningService).getMeaning(number, type);
    }
}