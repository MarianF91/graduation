package com.example.service;

import com.example.model.MeaningType;
import com.example.model.NumerologyMeaning;
import com.example.repository.NumerologyMeaningRepository;
import org.springframework.stereotype.Service;

@Service
public class MeaningServiceImpl implements MeaningService {

    private final NumerologyMeaningRepository repo;

    public MeaningServiceImpl(NumerologyMeaningRepository repo) {
        this.repo = repo;
    }

    @Override
    public String getMeaning(int number, MeaningType type) {
        return repo.findByNumberAndType(number, type)
                .map(NumerologyMeaning::getDescription)
                .orElse("No meaning found for " + number + " (" + type + ")");
    }
}