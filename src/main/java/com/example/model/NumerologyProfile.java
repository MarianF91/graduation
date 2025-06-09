package com.example.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity which retains all the calculated numbers for a {@link User}.
 * Owns the foreign key ( <code>user_id</code> ), thus, it's the
 * "owning side" in the one-to-one relationship.
 */

@Entity
@Table(name = "numerology_profile")
@Getter
@Setter
public class NumerologyProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", unique = true)
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