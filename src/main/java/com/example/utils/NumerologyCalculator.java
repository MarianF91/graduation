package com.example.graduation.utils;

import static java.lang.Character.getNumericValue;

public class NumerologyCalculator {

    public static int calculateDestinyNumber(int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        int sum = yearOfBirth + monthOfBirth + dayOfBirth;
        return reduceToSingleDigit(sum);
    }

    public static int calculateSoulNumber(int dayOfBirth) {
        return reduceToSingleDigit(dayOfBirth);
    }

    public static int calculatePersonalityNumber(int monthOfBirth) {
        return reduceToSingleDigit(monthOfBirth);
    }

    public static int calculateMaturityNumber(int destinyNumber, int personalityNumber) {
        return reduceToSingleDigit(destinyNumber + personalityNumber);
    }

    public static int calculateExpressionNumber(String fullName) {
        int sum = 0;
        for (char c : fullName.toCharArray()) {
            if (Character.isLetter(c)) {
                sum += getNumericValue(c);
            }
        }
        return reduceToSingleDigit(sum);
    }

    //letter to number conversion
    private static int letterToNumber(char letter) {
        int numericValue = (Character.toUpperCase(letter) - 'A' + 1);
        return (numericValue - 1) % 9 + 1;
    }


    private static int reduceToSingleDigit(int num) {
        System.out.println("ReduceToSingleDigit entry num: " + num);
        while (num > 9) {
            int sum = 0;
            System.out.println("ReduceToSingleDigit <while> loop entry: " + sum);
            while (num > 0) {
                sum += num % 10;
                System.out.println("  sum = " + sum + ", num % 10 = " + num % 10 + ", num = " + num);
                num /= 10;
            }
            num = sum;
            System.out.println("ReduceToSingleDigit <while> loop exit: " + sum);
        }
        System.out.println(" reduceToSingleDigit() exit: num = " + num);
        return num;
    }

    //leap year checks
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0)
                || (year % 400 == 0);
    }

    //destiny number descriptions
    public static String getDestinyDescription(int destinyNumber) {
        return switch (destinyNumber) {
            case 1 -> "This means that you are an independent person, an innovator or, why not, a leader." +
                    " Be careful not to become stubborn or egocentric.";
            case 2 -> "This means that you are a diplomat and a cooperative and intuitive person." +
                    " Try not to become passive and undecided.";
            case 3 -> "This means that you are creative, expressive and optimistic. " +
                    "Try not to become shallow and erratic.";
            case 4 -> "This means that you are practical, organized and reliable." +
                    " Try not to become stubborn and rigid.";
            case 5 -> "This means that you are an adventurer, a free spirit and an adaptable person." +
                    " Try not to become unpredictable and unreliable.";
            case 6 -> "This means that you are harmonious, loving and responsible. " +
                    "Try not to become possessive or focused only on pleasure.";
            case 7 -> "This means that you are wise, spiritual and analytic. Try not to become withdrawn and solitary.";
            case 8 -> "This means that you are strong, ambitious and materialistic." +
                    " Try not to become arrogant and manipulative.";
            case 9 -> "This means that you are wise, selfless and a humanitarian. " +
                    "Try not become too idealistic and detached.";
            default -> "Invalid destiny number.";
        };
    }

    //expression number description
    public static String getExpressionDescription(int expressionNumber) {
        return switch (expressionNumber) {
            case 1 -> "This means that you are natural leader and a project starter. " +
                    "Try not to become too dominant and authoritarian.";
            case 2 -> "This means that you are a diplomat, cooperative and a good communicator. " +
                    "Try not to become passive and undecided.";
            case 3 -> "This means that you are a diplomat, cooperative and a good communicator." +
                    " Try not to become passive and undecided.";
            case 4 -> "This means that you are a practical, organized and a good builder." +
                    " Try not to become rigid and stubborn.";
            case 5 -> "This means that you are an adventurer, a free spirit and an adaptable person. " +
                    "Try not to become unpredictable and unreliable.";
            case 6 -> "This means that you are harmonious, loving and responsible. " +
                    "Try not to become possessive or focused only on pleasure.";
            case 7 -> "This means that you are wise, spiritual and analytic. " +
                    "Try not to become withdrawn and solitary.";
            case 8 -> "This means that you are strong, ambitious and materialistic. " +
                    "Try not to become arrogant and manipulative.";
            case 9 -> "This means that you are wise, selfless and a humanitarian." +
                    " Try not become too idealistic and detached.";
            default -> "Invalid expression number.";
        };
    }

    //soul number description
    public static String getSoulDescription(int soulNumber) {
        return switch (soulNumber) {
            case 1 -> "Your soul desires: independence and affirmation. Try not to become egocentric and competitive.";
            case 2 -> "Your soul desires: harmony and relationships. Try not to become passive and undecided.";
            case 3 -> "Your soul desires: expressiveness and creativity. Try not to become shallow and erratic.";
            case 4 -> "Your soul desires: stability and safety. Try not to become rigid and stubborn.";
            case 5 -> "Your soul desires: freedom and adventure. Try not to become unpredictable and unreliable.";
            case 6 -> "Your soul desires: love and family. Try not to become possessive and interested only" +
                    " in pleasure.";
            case 7 -> "Your soul desires: knowledge and wisdom. Try not to become withdrawn and solitary.";
            case 8 -> "Your soul desires: power and material success. Try not to become arrogant and manipulative.";
            case 9 -> "Your soul desires: to help others and make the world a better place. Try not to become too" +
                    " idealistic and detached.";
            default -> "Invalid soul number.";
        };
    }

    //personality number description
    public static String getPersonalityDescription(int personalityNumber) {
        return switch (personalityNumber) {
            case 1 -> "Good traits: independent, confident, a leader.\tBad traits: arrogant, authoritarian.";
            case 2 -> "Good traits: diplomat, cooperative, adaptable.\tBad traits: undecided, passive.";
            case 3 -> "Good traits: sociable, expressive, optimistic.\tBad traits: shallow, erratic.";
            case 4 -> "Good traits: practical, organized, reliable.\tBad traits: rigid, stubborn.";
            case 5 -> "Good traits: adventurous, free, adaptable.\tBad traits: unpredictable, unreliable.";
            case 6 ->
                    "Good traits: harmonious, responsible, loving.\tBad traits: possessive, interested only in pleasures.";
            case 7 -> "Good traits: wise, spiritual, analytic.\tBad traits: withdrawn, solitary.";
            case 8 -> "Good traits: ambitious, strong, materialistic.\tBad traits: arrogant, manipulative.";
            case 9 -> "Good traits: humanitarian, wise, altruistic.\tBad traits: idealistic, detached.";
            default -> "Invalid personality number.";
        };
    }

    //maturity number description
    public static String getMaturityDescription(int maturityNumber) {
        return switch (maturityNumber) {
            case 1 -> "You need to take on responsibilities and become independent.";
            case 2 -> "You need to find balance between your needs and the needs of others.";
            case 3 -> "You need to find a way to express yourself and your creativity.";
            case 4 -> "You need to build a solid foundation on which you can organise your life.";
            case 5 -> "You need to explore the world and overcome your limits.";
            case 6 -> "You need to cultivate your relationships and start a family.";
            case 7 -> "You need to further your knowledge and increase your spirituality.";
            case 8 -> "You need to use your power and influence in a constructive way.";
            case 9 -> "You need to serve humanity and leave behind a positive legacy.";
            default -> "Invalid maturity number.";
        };
    }

}
