package com.example.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserDtoValidationTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @Test
    void validDate_shouldPassValidation() {
        UserDto dto = new UserDto("Ana", "Pop", 2024, 2, 29);
        Set<ConstraintViolation<UserDto>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void invalidDate_shouldAddErrorToBirthDay() {
        UserDto dto = new UserDto("Ana", "Pop", 2023, 2, 30); // 30 feb – invalid
        Set<ConstraintViolation<UserDto>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("birthDay")
                        && v.getMessage().equals("Date is not valid (e.g. 30 Feb)")));
    }
}