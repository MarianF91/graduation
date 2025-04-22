package com.example.dto;

public record NumerologyProfileResponse(
        Long id,
        ProfileDto destiny,
        ProfileDto soulUrge,
        ProfileDto personality,
        ProfileDto expression,
        ProfileDto maturity,
        String firstName,
        String lastName
) {
}