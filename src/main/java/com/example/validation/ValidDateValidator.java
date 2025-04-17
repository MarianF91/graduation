package com.example.validation;

import com.example.dto.UserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ValidDateValidator implements ConstraintValidator<ValidDate, UserDto> {

    @Override
    public boolean isValid(UserDto dto, ConstraintValidatorContext context) {
        try {
            LocalDate.of(dto.birthYear(), dto.birthMonth(), dto.birthDay());
            return true;
        } catch (DateTimeException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Date is not valid (e.g. 30 Feb)")
                    .addPropertyNode("birthDay")
                    .addConstraintViolation();
            return false;
        }
    }
}