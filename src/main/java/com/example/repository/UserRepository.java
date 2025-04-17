package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
            String firstName, String lastName, int birthYear, int birthMonth, int birthDay);
}