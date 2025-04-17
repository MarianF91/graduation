package com.example.service;

import com.example.model.NumerologyMeaning;
import com.example.repository.NumerologyMeaningRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MeaningServiceTest {

    @Mock
    private NumerologyMeaningRepository meaningRepository;

    @InjectMocks
    private MeaningService meaningService;

    @Test
    void shouldReturnMeaningWhenFound() {
        NumerologyMeaning meaning = new NumerologyMeaning(6, "destiny", "You care about others.");
        when(meaningRepository.findByNumberAndType(6, "destiny"))
                .thenReturn(Optional.of(meaning));

        String result = meaningService.getMeaning(6, "destiny");

        assertThat(result).isEqualTo("You care about others.");
        verify(meaningRepository).findByNumberAndType(6, "destiny");
    }

    @Test
    void shouldReturnFallbackIfNotFound() {
        when(meaningRepository.findByNumberAndType(99, "destiny"))
                .thenReturn(Optional.empty());

        String result = meaningService.getMeaning(99, "destiny");

        assertThat(result).isEqualTo("No meaning found for 99 (destiny)");
    }
}
