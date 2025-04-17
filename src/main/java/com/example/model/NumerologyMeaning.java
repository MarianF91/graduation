package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "numerology_meaning")
@IdClass(NumerologyMeaningId.class)
@Getter
@Setter
public class NumerologyMeaning {

    @Id
    private int number;

    @Id
    private String type;

    @Column(length = 2000)
    private String description;
}