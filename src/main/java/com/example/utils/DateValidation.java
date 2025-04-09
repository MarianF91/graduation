package com.example.graduation.utils;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateValidation {
    //checks for the number of days in a month
    public static int getDaysInMonth(int month, int year) {
        return LocalDate.of(year, month, 1).lengthOfMonth();
    }

    //checks for valid date
    public static boolean isValidDate(int day, int month, int year) {
        if (day <= 0 || month <= 0 || year <= 0) {
            return false; // no negative dates
        }
        if (month == 2 && day > 29) {
            return false; // February has less than 29 days
        }
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            return false; // February 29th is only during leap years
        }
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }



    //checks for leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}