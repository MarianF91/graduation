package com.example.repository;

import com.example.model.NumerologyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<NumerologyProfile, Long> {}