package com.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumerologyCalculatorTest {

    @Test
    void testCalculateDestinyNumber() {

        int destiny = NumerologyCalculator.calculateDestinyNumber(1991, 4, 27);
        assertEquals(33, destiny);
    }

    @Test
    void testCalculateLifePathNumber() {
        int lifePath = NumerologyCalculator.calculateLifePathNumber(1991, 4, 27);
        assertEquals(6, lifePath);
    }
}
