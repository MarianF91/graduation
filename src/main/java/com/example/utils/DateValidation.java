package com.example.utils;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateValidation {

    private DateValidation() {
        // Utility class – no instantiation allowed
    }

    public static int getDaysInMonth(int month, int year) {
        return LocalDate.of(year, month, 1).lengthOfMonth();
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (day <= 0 || month <= 0 || year <= 0) return false;
        if (month > 12) return false;
        if (day > 31) return false;

        if (month == 2 && day > 29) return false;
        if (month == 2 && day == 29 && !isLeapYear(year)) return false;

        // Avoids unnecessary exception handling for obvious invalid inputs
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}