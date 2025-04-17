package com.example.service;

import com.example.model.NumerologyMeaning;
import com.example.repository.NumerologyMeaningRepository;
import org.springframework.stereotype.Service;

@Service
public class MeaningService {

    private final NumerologyMeaningRepository repository;

    public MeaningService(NumerologyMeaningRepository repository) {
        this.repository = repository;
    }

    public String getMeaning(int number, String type) {
        return repository.findByNumberAndType(number, type)
                .map(NumerologyMeaning::getDescription)
                .orElse("No meaning found for " + number + " (" + type + ")");
    }
}
