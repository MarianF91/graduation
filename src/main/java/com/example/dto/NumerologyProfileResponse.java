package com.example.dto;

public record NumerologyProfileResponse(
        Long id,
        int destinyNumber,
        int soulUrgeNumber,
        int personalityNumber,
        int expressionNumber,
        int maturityNumber,
        String firstName,
        String lastName) {
}