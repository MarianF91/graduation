package com.example.dto;

public record NumerologyProfileResponse(
        Long id,
        ProfileDto destiny,
        ProfileDto lifePath,
        ProfileDto expression,
        ProfileDto soulUrge,
        ProfileDto personality,
        ProfileDto birthday,
        ProfileDto maturity,
        ProfileDto balance,
        ProfileDto lesson,
        String firstName,
        String lastName
) {
}