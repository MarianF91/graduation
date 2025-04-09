package com.example.graduation.utils;

import com.example.graduation.model.NumerologyProfile;
import com.example.graduation.model.User;

public class ResultPrinter {
    public static void printProfile(NumerologyProfile profile, User user) {
        System.out.println("\nNumerology Profile for " + user.firstName() + " " + user.lastName());
        System.out.println("Destiny Number: " + profile.getDestinyNumber());
        System.out.println("Soul Number: " + profile.getSoulNumber());
        System.out.println("Personality Number: " + profile.getPersonalityNumber());
        System.out.println("Maturity Number: " + profile.getMaturityNumber());
        System.out.println("Expression Number: " + profile.getExpressionNumber());

        if (NumerologyCalculator.isLeapYear(profile.getBirthYear())) {
            System.out.println("You were born in a leap year.");
        } else {
            System.out.println("You were not born in a leap year.");
        }
    }
}
