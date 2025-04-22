// src/main/java/com/example/model/User.java
package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String firstName;
    @Column(nullable = false) private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public User(String firstName, String lastName, int birthYear, int birthMonth, int birthDay) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.birthYear = birthYear;
        this.birthMonth= birthMonth;
        this.birthDay  = birthDay;
    }
}