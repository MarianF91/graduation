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
        NumerologyMeaning mockMeaning = new NumerologyMeaning();
        mockMeaning.setDescription("You are a leader.");

        when(repository.findByIdNumberAndIdType(1, MeaningType.DESTINY))
                .thenReturn(Optional.of(mockMeaning));

        String result = service.getMeaning(1, MeaningType.DESTINY);

        assertEquals("You are a leader.", result);
    }

    @Test
    void returnsFallbackMessageIfNotFound() {
        when(repository.findByIdNumberAndIdType(99, MeaningType.MATURITY))
                .thenReturn(Optional.empty());

        String result = service.getMeaning(99, MeaningType.MATURITY);

        assertEquals("No meaning found for 99 (MATURITY)", result);
    }
}