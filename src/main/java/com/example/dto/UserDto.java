package com.example.dto;

import com.example.validation.ValidDate;
import jakarta.validation.constraints.*;

@ValidDate
public record UserDto(
        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @Min(value = 1900, message = "Year must be after 1900")
        @Max(value = 2100, message = "Year must be before 2100")
        int birthYear,

        @Min(value = 1, message = "Month must be between 1 and 12")
        @Max(value = 12, message = "Month must be between 1 and 12")
        int birthMonth,

        @Min(value = 1, message = "Day must be between 1 and 31")
        @Max(value = 31, message = "Day must be between 1 and 31")
        int birthDay
) { }