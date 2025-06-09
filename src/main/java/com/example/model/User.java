package com.example.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Persists a natural person whose data is at the base of the numerological profile.
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Required columns */
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    /** Date-of-birth (kept split for easy calculations) */
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    /**
     * Convenience constructor used in tests / mapper.
     */
    public User(String firstName,
                String lastName,
                int birthYear,
                int birthMonth,
                int birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    /** One-to-one back reference; cascade removal handled în @OneToOne */
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private NumerologyProfile profile;
}