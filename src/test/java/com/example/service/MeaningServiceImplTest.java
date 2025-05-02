package com.example.service;

import com.example.model.MeaningType;
import com.example.model.NumerologyMeaning;
import com.example.repository.NumerologyMeaningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MeaningServiceImplTest {

    @Mock
    private NumerologyMeaningRepository repository;

    private MeaningServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new MeaningServiceImpl(repository);
    }

    @Test
    void returnsMeaningIfFound() {
        NumerologyMeaning mockMeaning = new NumerologyMeaning(
                5,
                MeaningType.LIFE_PATH,
                "You follow your life road with passion."
        );

        when(repository.findByNumberAndType(5, MeaningType.LIFE_PATH))
                .thenReturn(Optional.of(mockMeaning));

        String result = service.getMeaning(5, MeaningType.LIFE_PATH);

        assertEquals("You follow your life road with passion.", result);
    }

    @Test
    void whenNotFound_throwsStatus404() {
        when(repository.findByNumberAndType(13, MeaningType.LESSON))
                .thenReturn(Optional.empty());

                ResponseStatusException ex = assertThrows(
                ResponseStatusException.class,
                () -> service.getMeaning(13, MeaningType.LESSON)
        );
        assertEquals(404, ex.getStatusCode().value());
    }
}