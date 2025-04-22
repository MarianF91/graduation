package com.example.utils;

import com.example.model.NumerologyProfile;
import com.example.model.User;

public class NumerologyCalculator {

    public static NumerologyProfile generateProfile(User user) {
        NumerologyProfile p = new NumerologyProfile();
        p.setUser(user);

        int lifePath = calculateLifePathNumber(user.getBirthYear(), user.getBirthMonth(), user.getBirthDay());
        int destiny = calculateDestinyNumber(user.getBirthYear(), user.getBirthMonth(), user.getBirthDay());
        int expression = calculateExpressionNumber(user.getFirstName() + " " + user.getLastName());
        int soulUrge = calculateSoulUrgeNumber(user.getFirstName() + " " + user.getLastName());
        int personality = calculatePersonalityNumber(user.getFirstName() + " " + user.getLastName());
        int birthday = calculateBirthdayNumber(user.getBirthDay());
        int maturity = calculateMaturityNumber(destiny, expression);
        int balance = calculateBalanceNumber(destiny, birthday);
        int lesson = calculateLessonNumber(user.getBirthDay());

        p.setLifePathNumber(lifePath);
        p.setDestinyNumber(destiny);
        p.setLifePathNumber(destiny); // Optional: if using both
        p.setExpressionNumber(expression);
        p.setSoulUrgeNumber(soulUrge);
        p.setPersonalityNumber(personality);
        p.setBirthdayNumber(birthday);
        p.setMaturityNumber(maturity);
        p.setBalanceNumber(balance);
        p.setLessonNumber(lesson);

        return p;
    }

    public static int calculateLifePathNumber(int year, int month, int day) {
                int reducedDay = reduceWithMasterNumbers(day);
        int reducedMonth = reduceWithMasterNumbers(month);
        int reducedYear = reduceWithMasterNumbers(year);

        int total = reducedDay + reducedMonth + reducedYear;
        return reduceWithMasterNumbers(total);
    }

    public static int calculateDestinyNumber(int year, int month, int day) {
        int total = sumDigits(year) + sumDigits(month) + sumDigits(day);
        return reduceWithMasterNumbers(total);
    }

    public static int calculateBirthdayNumber(int dayOfMonth) {
        return reduceWithMasterNumbers(dayOfMonth);
    }

    public static int calculateExpressionNumber(String name) {
        int sum = name.chars()
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .map(c -> c - 'A' + 1)
                .sum();
        return reduceWithMasterNumbers(sum);
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

    public static int calculateMaturityNumber(int destinyNumber, int expressionNumber) {
        return reduceWithMasterNumbers(destinyNumber + expressionNumber);
    }

    public static int calculateBalanceNumber(int destinyNumber, int birthdayNumber) {
        return reduceToSingleDigit(Math.abs(destinyNumber - birthdayNumber));
    }

    public static int calculateLessonNumber(int dayOfMonth) {
        return reduceWithMasterNumbers(dayOfMonth);
    }

    private static int sumDigits(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static int reduceWithMasterNumbers(int n) {
        n = Math.abs(n);
        while (n > 9 && n != 11 && n != 22 && n != 33) {
            n = sumDigits(n);
        }
        return n;
    }

    private static int reduceToSingleDigit(int n) {
        n = Math.abs(n);
        while (n > 9) {
            n = sumDigits(n);
        }
        return n;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}