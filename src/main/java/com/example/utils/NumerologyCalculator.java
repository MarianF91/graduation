package com.example.utils;

import com.example.model.NumerologyProfile;
import com.example.model.User;

import java.util.function.IntPredicate;

/**
 * <h2>NumerologyCalculator</h2>
 *
 * <p>Classes with static methods which calculate all the numbers used in numerology
 * and build a {@link NumerologyProfile} for a{@link User}.</p>
 *
 * <ul>
 *   <li>all the methods are <em>pure functions</em> – they have no side effects;</li>
 *   <li>master-numbers (11, 22, 33) are not reduced to a single digit;</li>
 *   <li>for regular numbers we use the classic reduction (e.g.: &nbsp;38 → 3 + 8 = 11 → 1 + 1 = 2).</li>
 * </ul>
 */
public final class NumerologyCalculator {

    private NumerologyCalculator() {}      // utility-class

    //Constants

    private static final int MASTER_11 = 11;
    private static final int MASTER_22 = 22;
    private static final int MASTER_33 = 33;

    private static final String VOWELS = "AEIOUY";

    //Public API

    /**
     * Generates a complete {@link NumerologyProfile} for the user.
     */
    public static NumerologyProfile generateProfile(User user) {
        NumerologyProfile p = new NumerologyProfile();
        p.setUser(user);

        int lifePath     = calculateLifePathNumber(user.getBirthYear(),
                user.getBirthMonth(),
                user.getBirthDay());
        String fullName  = user.getFirstName() + ' ' + user.getLastName();

        int destiny      = calculateDestinyNumber(fullName);
        int expression   = calculateExpressionNumber(fullName);
        int soulUrge     = calculateSoulUrgeNumber(fullName);
        int personality  = calculatePersonalityNumber(fullName);
        int birthday     = calculateBirthdayNumber(user.getBirthDay());
        int maturity     = calculateMaturityNumber(destiny, lifePath);
        int balance      = calculateBalanceNumber(destiny, birthday);
        int lesson       = calculateLessonNumber(user.getBirthDay());

        p.setLifePathNumber     (lifePath);
        p.setDestinyNumber      (destiny);
        p.setExpressionNumber   (expression);
        p.setSoulUrgeNumber     (soulUrge);
        p.setPersonalityNumber  (personality);
        p.setBirthdayNumber     (birthday);
        p.setMaturityNumber     (maturity);
        p.setBalanceNumber      (balance);
        p.setLessonNumber       (lesson);

        return p;
    }

    /** Life Path number */
    public static int calculateLifePathNumber(int year, int month, int day) {
        int y = reduceWithMasterNumbers(sumDigits(year));
        int m = reduceWithMasterNumbers(sumDigits(month));
        int d = reduceWithMasterNumbers(sumDigits(day));
        return reduceWithMasterNumbers(y + m + d);
    }

    /** Destiny Number – calculated using master-numbers. */
    public static int calculateDestinyNumber(String fullName) {
        return reduceWithMasterNumbers(alphabeticSum(fullName, c -> true));
    }

    /** Expression Number – always reduced to a single digit. */
    public static int calculateExpressionNumber(String fullName) {
        return reduceToSingleDigit(alphabeticSum(fullName.replaceAll("\\s+", ""), c -> true));
    }

    /** Soul Urge – based only on vowels. */
    public static int calculateSoulUrgeNumber(String fullName) {
        return reduceWithMasterNumbers(
                alphabeticSum(fullName, c -> VOWELS.indexOf(c) >= 0));
    }

    /** Personality Number – based only on consonants. */
    public static int calculatePersonalityNumber(String fullName) {
        return reduceWithMasterNumbers(
                alphabeticSum(fullName, c -> VOWELS.indexOf(c) < 0));
    }

    /** Birthday Number */
    public static int calculateBirthdayNumber(int dayOfMonth) {
        return reduceWithMasterNumbers(dayOfMonth);
    }

    /** Maturity Number – Destiny + LifePath. */
    public static int calculateMaturityNumber(int destiny, int lifePath) {
        return reduceWithMasterNumbers(destiny + lifePath);
    }

    /** Balance Number – |Destiny − Birthday| reduced to a single digit. */
    public static int calculateBalanceNumber(int destiny, int birthday) {
        return reduceToSingleDigit(Math.max(1, Math.abs(destiny - birthday)));
    }

    /** Lesson Number */
    public static int calculateLessonNumber(int day) {
        return reduceWithMasterNumbers(day);
    }

    //Helpers

    /** Sum of all the filtered alphabetic values. */
    private static int alphabeticSum(String text, IntPredicate filter) {
        return text.chars()
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .filter(filter)
                .map(c -> c - 'A' + 1)
                .sum();
    }

    private static int reduceWithMasterNumbers(int n) {
        n = Math.abs(n);
        while (n > 9 && n != MASTER_11 && n != MASTER_22 && n != MASTER_33) {
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

    private static int sumDigits(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n  /= 10;
        }
        return sum;
    }
}