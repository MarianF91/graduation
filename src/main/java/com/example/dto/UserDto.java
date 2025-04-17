package com.example.dto;

public record UserDto(
        String firstName,
        String lastName,
        int birthYear,
        int birthMonth,
        int birthDay) {}