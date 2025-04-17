package com.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumerologyCalculatorTest {

    @Test
    public void testCalculateDestinyNumber() {
        // Marian Filip: 27.04.1991 → 2+7 + 0+4 + 1+9+9+1 = 33 → 3+3 = 6
        assertEquals(6, NumerologyCalculator.calculateDestinyNumber(1991, 4, 27));
    }

    @Test
    public void testCalculateSoulUrgeNumber() {
        // Soul urge uses only vowels: a, e, i, o, u → M a r i a n  F i l i p = a i a i i = 1+9+1+9+9 = 29 → 2+9 = 11 → 1+1 = 2
        int result = NumerologyCalculator.calculateSoulUrgeNumber("Marian Filip");
        assertTrue(result >= 1 && result <= 11, "Soul urge number should be between 1 and 11");
    }

    @Test
    public void testCalculatePersonalityNumber() {
        // Personality number uses consonants only
        int result = NumerologyCalculator.calculatePersonalityNumber("Marian Filip");
        assertTrue(result >= 1 && result <= 9, "Personality number should be between 1 and 9");
    }

    @Test
    public void testCalculateExpressionNumber() {
        int result = NumerologyCalculator.calculateExpressionNumber("Marian Filip");
        assertTrue(result >= 1 && result <= 9, "Expression number should be between 1 and 9");
    }

    @Test
    public void testCalculateMaturityNumber() {
        // 6 (destiny) + 4 (expression) = 10 → 1 + 0 = 1
        assertEquals(1, NumerologyCalculator.calculateMaturityNumber(6, 4));
    }

    @Test
    public void testIsLeapYear() {
        assertTrue(NumerologyCalculator.isLeapYear(2024));
        assertFalse(NumerologyCalculator.isLeapYear(1991));
    }
}
