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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "users_id_seq", allocationSize = 1)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
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
