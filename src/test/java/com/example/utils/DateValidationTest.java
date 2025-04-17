package com.example.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.DateTimeException;
import java.time.LocalDate;

public class DateValidationTest {

    @Test
    public void testIsValidDate() {
        Assertions.assertTrue(DateValidation.isValidDate(1, 1, 2023), "1 Jan 2023 should be valid");
        Assertions.assertFalse(DateValidation.isValidDate(31, 2, 2023), "31 Feb 2023 is invalid");
        Assertions.assertTrue(DateValidation.isValidDate(29, 2, 2024), "29 Feb 2024 is valid (leap year)");
    }

    @Test
    public void testIsLeapYear() {
        Assertions.assertTrue(DateValidation.isLeapYear(2024), "2024 should be a leap year");
        Assertions.assertFalse(DateValidation.isLeapYear(2023), "2023 is not a leap year");
    }

    @Test
    public void testInvalidDates() {
        Assertions.assertFalse(DateValidation.isValidDate(0, 1, 2023), "Day 0 is invalid");
        Assertions.assertFalse(DateValidation.isValidDate(1, 0, 2023), "Month 0 is invalid");
        Assertions.assertFalse(DateValidation.isValidDate(29, 2, 2023), "2023 is not leap year");
        Assertions.assertFalse(DateValidation.isValidDate(30, 2, 2024), "February never has 30 days");
        Assertions.assertFalse(DateValidation.isValidDate(31, 2, 2023), "31st Feb is invalid");
        Assertions.assertFalse(DateValidation.isValidDate(31, 4, 2023), "April has only 30 days");
        Assertions.assertFalse(DateValidation.isValidDate(31, 6, 2023), "June has only 30 days");
        Assertions.assertFalse(DateValidation.isValidDate(31, 9, 2023), "September has only 30 days");
        Assertions.assertFalse(DateValidation.isValidDate(31, 11, 2023), "November has only 30 days");
        Assertions.assertFalse(DateValidation.isValidDate(1, 13, 2023), "There is no month 13");
        Assertions.assertFalse(DateValidation.isValidDate(-1, 1, 2023), "Negative day is invalid");
        Assertions.assertFalse(DateValidation.isValidDate(1, -1, 2023), "Negative month is invalid");
        Assertions.assertFalse(DateValidation.isValidDate(1, 1, -2023), "Negative year is invalid");
        Assertions.assertFalse(DateValidation.isValidDate(32, 1, 2023), "There is no 32nd day in any month");
    }

    @Test
    public void testLeapYearEdgeCases() {
        Assertions.assertTrue(DateValidation.isLeapYear(4), "Year 4 is leap (divisible by 4)");
        Assertions.assertTrue(DateValidation.isLeapYear(400), "Year 400 is leap (divisible by 400)");
        Assertions.assertFalse(DateValidation.isLeapYear(100), "Year 100 is not leap (divisible by 100 but not 400)");
    }

    @Test
    public void testLocalDateThrowsOnInvalidDate() {
        Assertions.assertThrows(DateTimeException.class, () -> LocalDate.of(2024, 2, 30),
                "Should throw DateTimeException for 30 Feb 2024");
    }
}