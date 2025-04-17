package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "numerology_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NumerologyProfile {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private int destinyNumber;
    private int soulUrgeNumber;
    private int personalityNumber;
    private int maturityNumber;
    private int expressionNumber;

    public NumerologyProfile(int destiny, int soulUrge, int personality, int expression, int maturity) {
        this.destinyNumber = destiny;
        this.soulUrgeNumber = soulUrge;
        this.personalityNumber = personality;
        this.expressionNumber = expression;
        this.maturityNumber = maturity;
    }
}
