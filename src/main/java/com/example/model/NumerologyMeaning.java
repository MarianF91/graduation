package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "numerology_meaning")
@IdClass(NumerologyMeaningId.class)
public class NumerologyMeaning {

    @Id
    private int number;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MeaningType type;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    public NumerologyMeaning() {}

    public NumerologyMeaning(int number, MeaningType type, String description) {
        this.number = number;
        this.type = type;
        this.description = description;
    }
}