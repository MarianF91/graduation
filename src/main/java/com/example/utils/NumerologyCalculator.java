package com.example.utils;

import com.example.model.NumerologyProfile;
import com.example.model.User;

public class NumerologyCalculator {

    public static NumerologyProfile generateProfile(User user) {
        String fullName = user.getFirstName() + user.getLastName();

        int destiny = calculateDestinyNumber(user.getBirthYear(), user.getBirthMonth(), user.getBirthDay());
        int soulUrge = calculateSoulUrgeNumber(fullName);
        int personality = calculatePersonalityNumber(fullName);
        int expression = calculateExpressionNumber(fullName);
        int maturity = reduceToSingleDigit(destiny + expression);

        return new NumerologyProfile(destiny, soulUrge, personality, expression, maturity);
    }

    public static int calculateDestinyNumber(int year, int month, int day) {
        return reduceToSingleDigit(year + month + day);
    }

    public static int calculateSoulUrgeNumber(String name) {
        return reduceToSingleDigit(
                name.toUpperCase().chars()
                        .filter(Character::isLetter)
                        .filter(c -> "AEIOU".indexOf(c) >= 0)
                        .map(NumerologyCalculator::letterToNumber)
                        .sum()
        );
    }

    public static int calculatePersonalityNumber(String name) {
        return reduceToSingleDigit(
                name.toUpperCase().chars()
                        .filter(Character::isLetter)
                        .filter(c -> "AEIOU".indexOf(c) < 0)
                        .map(NumerologyCalculator::letterToNumber)
                        .sum()
        );
    }

    public static int calculateExpressionNumber(String name) {
        return reduceToSingleDigit(
                name.toUpperCase().chars()
                        .filter(Character::isLetter)
                        .map(NumerologyCalculator::letterToNumber)
                        .sum()
        );
    }

    public static int letterToNumber(int letter) {
        return (letter - 'A') % 9 + 1;
    }

    public static int reduceToSingleDigit(int number) {
        while (number > 9 && number != 11 && number != 22) {
            number = Integer.toString(number)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();
        }
        return number;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int calculateMaturityNumber(int destinyNumber, int lifePathNumber) {
        return reduceToSingleDigit(destinyNumber + lifePathNumber);
    }

}
