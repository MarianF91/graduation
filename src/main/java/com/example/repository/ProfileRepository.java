package com.example.repository;

import com.example.model.NumerologyProfile;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<NumerologyProfile, Long> {

    Optional<NumerologyProfile> findByUser(User user);
}