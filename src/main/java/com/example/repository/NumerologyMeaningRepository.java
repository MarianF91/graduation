package com.example.repository;

import com.example.model.NumerologyMeaning;
import com.example.model.NumerologyMeaningId;
import com.example.model.MeaningType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NumerologyMeaningRepository
        extends JpaRepository<NumerologyMeaning, NumerologyMeaningId> {

    Optional<NumerologyMeaning> findByIdNumberAndIdType(int number, MeaningType type);

}