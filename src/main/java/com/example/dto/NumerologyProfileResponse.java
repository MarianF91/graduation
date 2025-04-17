package com.example.dto;

public record NumerologyProfileResponse(
        Long id,
        int destinyNumber,
        String destinyMeaning,
        int soulUrgeNumber,
        String soulUrgeMeaning,
        int personalityNumber,
        String personalityMeaning,
        int expressionNumber,
        String expressionMeaning,
        int maturityNumber,
        String maturityMeaning,
        String firstName,
        String lastName
) {
}