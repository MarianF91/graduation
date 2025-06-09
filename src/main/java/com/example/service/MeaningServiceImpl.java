package com.example.service;

import com.example.exception.MeaningNotFoundException;
import com.example.model.MeaningType;
import com.example.model.NumerologyMeaning;
import com.example.repository.NumerologyMeaningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service-layer component which supplies the description of the number for a certain {@link MeaningType}
 * <p> throws {@link MeaningNotFoundException} when the pair
 * <code>(number, type)</code> does not exist within the db.</p>
 *
 * @implNote The methods are read-only, which is why the class is marked with {@code @Transactional(readOnly = true)}
 */
@Service
@RequiredArgsConstructor
public class MeaningServiceImpl implements MeaningService {

    private final NumerologyMeaningRepository repo;

    @Transactional(readOnly = true)
    @Override
    public String getMeaning(int number, MeaningType type) {
        return repo.findByNumberAndType(number, type)
                .map(NumerologyMeaning::getDescription)
                .orElseThrow(() -> new MeaningNotFoundException(number, type));
    }
}