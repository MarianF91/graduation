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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumerologyControllerTest {

    @Mock private MeaningService meaningService;
    @Mock private NumerologyService numerologyService;
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

    @Test
    void createProfile_returnsCreatedBody() {
        var dto = new UserDto("Marian","Filip",1991,4,27);
        var response = new NumerologyProfileResponse(
                1L,
                new ProfileDto(6,"M6"),    
                new ProfileDto(33,"M33"),
                new ProfileDto(5,"M5"),
                new ProfileDto(11,"M11"),
                new ProfileDto(7,"M7"),
                new ProfileDto(27,"Bday"),
                new ProfileDto(1,"Mat"),
                new ProfileDto(3,"Bal"),
                new ProfileDto(2,"Les"),
                "Marian", "Filip"
        );

        when(numerologyService.calculateProfile(dto)).thenReturn(response);

        ResponseEntity<NumerologyProfileResponse> resp = controller.create(dto);

        assertEquals(201, resp.getStatusCode().value());
        assertSame(response, resp.getBody());
        verify(numerologyService).calculateProfile(dto);
    }
}