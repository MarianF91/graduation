package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    private int birthYear;
    private int birthMonth;
    private int birthDay;

    // for test purposes
    public User(String firstName, String lastName,
                int birthYear, int birthMonth, int birthDay) {
        this(null, firstName, lastName, birthYear, birthMonth, birthDay);
    }
}
