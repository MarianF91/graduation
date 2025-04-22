package com.example.service;

import com.example.model.MeaningType;
import com.example.model.NumerologyMeaning;
import com.example.repository.NumerologyMeaningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MeaningServiceImplTest {

    @Mock
    private NumerologyMeaningRepository repository;

    @InjectMocks
    private MeaningServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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
    void returnsFallbackMessageIfNotFound() {
        when(repository.findByNumberAndType(13, MeaningType.LESSON))
                .thenReturn(Optional.empty());

        String result = service.getMeaning(13, MeaningType.LESSON);

        assertEquals("No meaning found for 13 (LESSON)", result);
    }
}