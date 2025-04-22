package com.example.service;

import com.example.model.MeaningType;
import com.example.model.NumerologyMeaning;
import com.example.repository.NumerologyMeaningRepository;
import org.springframework.stereotype.Service;

@Service
public class MeaningServiceImpl implements MeaningService {

    private final NumerologyMeaningRepository repository;

    public MeaningServiceImpl(NumerologyMeaningRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getMeaning(int number, MeaningType type) {
        return repository.findByIdNumberAndIdType(number, type)
                .map(NumerologyMeaning::getDescription)
                .orElse("No meaning found for " + number + " (" + type + ")");
    }
}
