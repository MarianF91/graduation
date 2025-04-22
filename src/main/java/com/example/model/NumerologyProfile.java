package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "numerology_profile")
@Getter @Setter
@NoArgsConstructor
public class NumerologyProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    private int destinyNumber;
    private int lifePathNumber;
    private int expressionNumber;
    private int soulUrgeNumber;
    private int personalityNumber;
    private int birthdayNumber;
    private int maturityNumber;
    private int balanceNumber;
    private int lessonNumber;
}