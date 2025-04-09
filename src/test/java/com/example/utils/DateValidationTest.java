package com.example.graduation.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.DateTimeException;
import java.time.LocalDate;

public class DateValidationTest {

    @Test
    public void testIsValidDate() {
        Assertions.assertTrue(DateValidation.isValidDate(1, 1, 2023));
        Assertions.assertFalse(DateValidation.isValidDate(31, 2, 2023));
        Assertions.assertTrue(DateValidation.isValidDate(29, 2, 2024));
    }

    @Test
    public void testIsLeapYear() {
        Assertions.assertTrue(DateValidation.isLeapYear(2024));
        Assertions.assertFalse(DateValidation.isLeapYear(2023));
    }

    @Test
    public void testInvalidDates() {
        Assertions.assertFalse(DateValidation.isValidDate(0, 1, 2023)); // day 0
        Assertions.assertFalse(DateValidation.isValidDate(1, 0, 2023)); // month 0
        Assertions.assertFalse(DateValidation.isValidDate(29, 2, 2023)); // 29th of february
        Assertions.assertFalse(DateValidation.isValidDate(30, 2, 2024), "30th of February is invalid!"); // 30th of february
        Assertions.assertFalse(DateValidation.isValidDate(31, 2, 2023)); // 31st of february
        Assertions.assertFalse(DateValidation.isValidDate(31, 4, 2023)); // 31st of april
        Assertions.assertFalse(DateValidation.isValidDate(31, 6, 2023)); // 31st of june
        Assertions.assertFalse(DateValidation.isValidDate(31, 9, 2023)); // 31st of september
        Assertions.assertFalse(DateValidation.isValidDate(31, 11, 2023)); // 31st of november
        Assertions.assertFalse(DateValidation.isValidDate(1, 13, 2023)); // month 13
        Assertions.assertFalse(DateValidation.isValidDate(-1, 1, 2023)); // negative day
        Assertions.assertFalse(DateValidation.isValidDate(1, -1, 2023)); // negative month
        Assertions.assertFalse(DateValidation.isValidDate(1, 1, -2023)); // negative year
        Assertions.assertFalse(DateValidation.isValidDate(32, 1, 2023)); // day too high
        Assertions.assertFalse(DateValidation.isValidDate(31, 2, 2023), "31 February is invalid!");
        Assertions.assertFalse(DateValidation.isValidDate(-1, 1, 2023), "-1 January is invalid!");
        Assertions.assertFalse(DateValidation.isValidDate(31, 4, 2023), "31 April is invalid!");

    }

    @Test
    public void testLeapYearEdgeCases() {
        Assertions.assertTrue(DateValidation.isLeapYear(4)); // leap year inferior limit
        Assertions.assertTrue(DateValidation.isLeapYear(400)); // leap year superior limit
        Assertions.assertFalse(DateValidation.isLeapYear(100)); // non-leap centennial year
    }

    @Test
    public void testLocalDateOf() {
        System.out.println("Java Time API version: " + LocalDate.now().getClass().getPackage().getImplementationVersion());
        Assertions.assertThrows(DateTimeException.class, () -> LocalDate.of(2024, 2, 30));
    }
}
