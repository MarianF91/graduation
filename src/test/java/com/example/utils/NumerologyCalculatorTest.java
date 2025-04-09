package com.example.graduation.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumerologyCalculatorTest {

    @Test
    public void testCalculateDestinyNumber() {
        Assertions.assertEquals(5, NumerologyCalculator.calculateDestinyNumber(1990, 1, 12));
        Assertions.assertEquals(4, NumerologyCalculator.calculateDestinyNumber(2000, 1, 1));
    }

    @Test
    public void testCalculateSoulNumber() {
        Assertions.assertEquals(1, NumerologyCalculator.calculateSoulNumber(1));
        Assertions.assertEquals(9, NumerologyCalculator.calculateSoulNumber(9));
        Assertions.assertEquals(3, NumerologyCalculator.calculateSoulNumber(12));
    }

    @Test
    public void testCalculatePersonalityNumber() {
        Assertions.assertEquals(1, NumerologyCalculator.calculatePersonalityNumber(1));
        Assertions.assertEquals(9, NumerologyCalculator.calculatePersonalityNumber(9));
        Assertions.assertEquals(3, NumerologyCalculator.calculatePersonalityNumber(12));
    }

    @Test
    public void testCalculateMaturityNumber() {
        Assertions.assertEquals(4, NumerologyCalculator.calculateMaturityNumber(1, 3));
        Assertions.assertEquals(9, NumerologyCalculator.calculateMaturityNumber(4, 5));
    }

    @Test
    public void testCalculateExpressionNumber() {
        Assertions.assertEquals(1, NumerologyCalculator.calculateExpressionNumber("A"));
        Assertions.assertEquals(9, NumerologyCalculator.calculateExpressionNumber("I"));
        Assertions.assertEquals(1, NumerologyCalculator.calculateExpressionNumber("J"));
    }

    @Test
    public void testIsLeapYear() {
        Assertions.assertTrue(NumerologyCalculator.isLeapYear(2024));
        Assertions.assertFalse(NumerologyCalculator.isLeapYear(2023));
    }

    @Test
    public void testGetDestinyDescription() {
        Assertions.assertEquals("This means that you are an independent person, an innovator or, why not," +
                        " a leader. Be careful not to become stubborn or egocentric.",
                NumerologyCalculator.getDestinyDescription(1));
        Assertions.assertEquals("Invalid destiny number.", NumerologyCalculator.getDestinyDescription(10));
    }

    @Test
    public void testGetExpressionDescription() {
        Assertions.assertEquals("This means that you are natural leader and a project starter. Try not to become too" +
                " dominant and authoritarian.", NumerologyCalculator.getExpressionDescription(1));
        Assertions.assertEquals("Invalid expression number.",
                NumerologyCalculator.getExpressionDescription(10));
    }

    @Test
    public void testGetSoulDescription() {
        Assertions.assertEquals("Your soul desires: independence and affirmation. Try not to become egocentric and" +
                " competitive.", NumerologyCalculator.getSoulDescription(1));
        Assertions.assertEquals("Invalid soul number.", NumerologyCalculator.getSoulDescription(10));
    }

    @Test
    public void testGetPersonalityDescription() {
        Assertions.assertEquals("Good traits: independent, confident, a leader.\tBad traits: arrogant, authoritarian.",
                NumerologyCalculator.getPersonalityDescription(1));
        Assertions.assertEquals("Invalid personality number.", NumerologyCalculator.getPersonalityDescription(10));
    }

    @Test
    public void testGetMaturityDescription() {
        Assertions.assertEquals("You need to take on responsibilities and become independent.",
                NumerologyCalculator.getMaturityDescription(1));
        Assertions.assertEquals("Invalid maturity number.", NumerologyCalculator.getMaturityDescription(10));
    }
}
