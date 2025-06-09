package com.example.validation;

import com.example.dto.UserDto;
import jakarta.validation.*;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ValidDateValidatorTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @Test
    void validDatePasses() {
        UserDto good = new UserDto("A", "B", 2000, 2, 29);
        Set<ConstraintViolation<UserDto>> violations = validator.validate(good);
        assertTrue(violations.isEmpty(), "Leap‐day 29/2/2000 should be valid");
    }

    @Test
    void invalidDateFails() {
        UserDto bad = new UserDto("A", "B", 2021, 2, 29);
        Set<ConstraintViolation<UserDto>> violations = validator.validate(bad);
        assertFalse(violations.isEmpty(), "Non‐leap 29/2/2021 should fail");
    }
}