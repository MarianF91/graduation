package com.example.utils;

import com.example.model.NumerologyProfile;
import com.example.model.User;

public class NumerologyCalculator {

    // Master numbers that are not reduced further
    private static final int MASTER_11 = 11;
    private static final int MASTER_22 = 22;
    private static final int MASTER_33 = 33;

    public static NumerologyProfile generateProfile(User user) {
        NumerologyProfile profile = new NumerologyProfile();
        profile.setUser(user);

        int lifePath = calculateLifePathNumber(user.getBirthYear(), user.getBirthMonth(), user.getBirthDay());
        int destiny = calculateDestinyNumber(user.getFirstName() + " " + user.getLastName());
        int expression = calculateExpressionNumber(user.getFirstName() + " " + user.getLastName());
        int soulUrge = calculateSoulUrgeNumber(user.getFirstName() + " " + user.getLastName());
        int personality = calculatePersonalityNumber(user.getFirstName() + " " + user.getLastName());
        int birthday = calculateBirthdayNumber(user.getBirthDay());
        int maturity = calculateMaturityNumber(destiny, lifePath);
        int balance = calculateBalanceNumber(destiny, birthday);
        int lesson = calculateLessonNumber(user.getBirthDay());

        profile.setLifePathNumber(lifePath);
        profile.setDestinyNumber(destiny);
        profile.setExpressionNumber(expression);
        profile.setSoulUrgeNumber(soulUrge);
        profile.setPersonalityNumber(personality);
        profile.setBirthdayNumber(birthday);
        profile.setMaturityNumber(maturity);
        profile.setBalanceNumber(balance);
        profile.setLessonNumber(lesson);

        return profile;
    }

    public static int calculateLifePathNumber(int year, int month, int day) {
        int reducedYear = reduceWithMasterNumbers(sumDigits(year));
        int reducedMonth = reduceWithMasterNumbers(sumDigits(month));
        int reducedDay = reduceWithMasterNumbers(sumDigits(day));

        int total = reducedYear + reducedMonth + reducedDay;
        return reduceWithMasterNumbers(total);
    }

    public static int calculateDestinyNumber(String fullName) {
        int sum = fullName.chars()
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .map(c -> c - 'A' + 1)
                .sum();
        return reduceWithMasterNumbers(sum);
    }

    public static int calculateExpressionNumber(String name) {
        int sum = name.replaceAll("\\s+", "").chars()
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .map(c -> c - 'A' + 1)
                .sum();
        return reduceToSingleDigit(sum);
    }

    public static int calculateSoulUrgeNumber(String name) {
        int sum = name.chars()
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .filter(c -> "AEIOUY".indexOf(c) >= 0)
                .map(c -> c - 'A' + 1)
                .sum();
        return reduceWithMasterNumbers(sum);
    }

    public static int calculatePersonalityNumber(String name) {
        int sum = name.chars()
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .filter(c -> "AEIOUY".indexOf(c) < 0)
                .map(c -> c - 'A' + 1)
                .sum();
        return reduceWithMasterNumbers(sum);
    }

    public static int calculateBirthdayNumber(int dayOfMonth) {
        return reduceWithMasterNumbers(dayOfMonth);
    }

    public static int calculateMaturityNumber(int destiny, int lifePath) {
        return reduceWithMasterNumbers(destiny + lifePath);
    }

    public static int calculateBalanceNumber(int destinyNumber, int birthdayNumber) {
        return reduceToSingleDigit(Math.max(1, Math.abs(destinyNumber - birthdayNumber)));
    }

    public static int calculateLessonNumber(int day) {
        return reduceWithMasterNumbers(day);
    }

    private static int reduceWithMasterNumbers(int number) {
        number = Math.abs(number);
        while (number > 9 && number != MASTER_11 && number != MASTER_22 && number != MASTER_33) {
            number = sumDigits(number);
        }
        return number;
    }

    private static int reduceToSingleDigit(int number) {
        number = Math.abs(number);
        while (number > 9) {
            number = sumDigits(number);
        }
        return number;
    }

    private static int sumDigits(int number) {
        number = Math.abs(number);
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}