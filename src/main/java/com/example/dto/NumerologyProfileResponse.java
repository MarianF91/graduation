package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NumerologyProfileResponse {
    private Long id;
    private ProfileDto destiny;
    private ProfileDto lifePath;
    private ProfileDto expression;
    private ProfileDto soulUrge;
    private ProfileDto personality;
    private ProfileDto birthday;
    private ProfileDto maturity;
    private ProfileDto balance;
    private ProfileDto lesson;
    private String firstName;
    private String lastName;
}