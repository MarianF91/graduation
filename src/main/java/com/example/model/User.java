package com.example.graduation.model;

public record User(String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {

    //date of birth validation
    public boolean isValidDate() {
        return yearOfBirth >= 1000 && yearOfBirth <= 9999 &&
                monthOfBirth >= 1 && monthOfBirth <= 12 &&
                dayOfBirth >= 1 && dayOfBirth <= 31;
    }
}
