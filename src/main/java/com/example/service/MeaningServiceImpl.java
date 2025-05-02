package com.example.service;

import com.example.model.MeaningType;
import com.example.model.NumerologyMeaning;
import com.example.repository.NumerologyMeaningRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}