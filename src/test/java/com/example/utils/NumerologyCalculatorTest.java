package com.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumerologyCalculatorTest {

    @Test
    void testCalculateDestinyNumber() {
        // Marian Filip -> M(13)+A(1)+R(18)+I(9)+A(1)+N(14)+F(6)+I(9)+L(12)+I(9)+P(16) = 108 → 1+0+8 = 9
        int destiny = NumerologyCalculator.calculateDestinyNumber("Marian Filip");
        assertEquals(9, destiny);
    }

    @Test
    void testCalculateLifePathNumber() {
        // 1991/04/27 -> 1+9+9+1 = 20 → 2; 0+4 = 4; 2+7 = 9 → 2+4+9 = 15 → 1+5 = 6
        int lifePath = NumerologyCalculator.calculateLifePathNumber(1991, 4, 27);
        assertEquals(6, lifePath);
    }
}