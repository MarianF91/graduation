package com.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "numerology_meaning")
@IdClass(NumerologyMeaningId.class)
public class NumerologyMeaning {

    @Id
    @Column(name = "number", nullable = false)
    private int number;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private MeaningType type;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    public NumerologyMeaning() {}

    public NumerologyMeaning(int number, MeaningType type, String description) {
        this.number = number;
        this.type = type;
        this.description = description;
    }

}