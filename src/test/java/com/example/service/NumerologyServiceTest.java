package com.example.graduation.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.graduation.model.NumerologyProfile;
import com.example.graduation.model.User;
import com.example.graduation.utils.NumerologyCalculator;

public class NumerologyServiceTest {

    @Test
    public void testProfileGenerator() {
        NumerologyService service = new NumerologyService();
        User user = new User("John", "Doe", 1990, 1, 12);
        NumerologyProfile profile = service.profileGenerator(user);

        Assertions.assertEquals(5, profile.getDestinyNumber());
        Assertions.assertEquals(3, NumerologyCalculator.calculateSoulNumber(12));
        Assertions.assertEquals(1, profile.getPersonalityNumber());
        Assertions.assertEquals(6, profile.getMaturityNumber());
        Assertions.assertEquals(8, profile.getExpressionNumber());
        Assertions.assertEquals(1990, profile.getBirthYear());
        Assertions.assertEquals("This means that you are an adventurer, a free spirit and an adaptable person." +
                " Try not to become unpredictable and unreliable.", profile.getDestinyDescription());
        Assertions.assertEquals("Your soul desires: expressiveness and creativity. Try not to become shallow and erratic."
                , profile.getSoulDescription());
        Assertions.assertEquals("Good traits: independent, confident, a leader.\tBad traits: arrogant, authoritarian."
                , profile.getPersonalityDescription());
        Assertions.assertEquals("You need to cultivate your relationships and start a family.",
                profile.getMaturityDescription());
        Assertions.assertEquals("This means that you are strong, ambitious and materialistic." +
                " Try not to become arrogant and manipulative.", profile.getExpressionDescription());
    }

    @Test
    public void testSpecialCharactersInName() {
        NumerologyService service = new NumerologyService();
        User user = new User("John!@#$", "Doe", 1990, 1, 12);
        NumerologyProfile profile = service.profileGenerator(user);

        // checks if the profile is generated correctly, even with special chars within it
        Assertions.assertEquals(5, profile.getDestinyNumber());
    }

    @Test
    public void testMultipleSpacesInName() {
        NumerologyService service = new NumerologyService();
        User user = new User("John   ", "   Doe", 1990, 1, 12);
        NumerologyProfile profile = service.profileGenerator(user);

        // checks if the profile is generated correctly, even with multiple spaces within it
        Assertions.assertEquals(5, profile.getDestinyNumber());
    }

    @Test
    public void testEmptyName() {
        NumerologyService service = new NumerologyService();
        User user = new User("", "", 1990, 1, 12);
        NumerologyProfile profile = service.profileGenerator(user);

        //checks if the profile is generated correctly, even with empty names
        Assertions.assertEquals(5, profile.getDestinyNumber());
    }
}