package com.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumerologyCalculatorTest {

    @Test
    public void testCalculateDestinyNumber() {

        assertEquals(6, NumerologyCalculator.calculateDestinyNumber(1991, 4, 27));
    }

    @Test
    public void testCalculateSoulUrgeNumber() {
        int result = NumerologyCalculator.calculateSoulUrgeNumber("Marian Filip");
        assertTrue(result >= 1 && result <= 11, "Soul urge number should be between 1 and 11");
    }

    @Test
    public void testCalculatePersonalityNumber() {
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
        assertEquals(1, NumerologyCalculator.calculateMaturityNumber(6, 4));
    }

    @Test
    public void testIsLeapYear() {
        assertTrue(NumerologyCalculator.isLeapYear(2024));
        assertFalse(NumerologyCalculator.isLeapYear(1991));
    }
}