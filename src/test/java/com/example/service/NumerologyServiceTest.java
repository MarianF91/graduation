package com.example.service;

import com.example.model.NumerologyProfile;
import com.example.model.User;
import com.example.repository.ProfileRepository;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NumerologyServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private NumerologyService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void generatesCorrectNumbersForMarianFilip() {
        User user = new User("Marian", "Filip", 1991, 4, 27);

        when(userRepository.save(any())).thenReturn(user);
        when(profileRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        NumerologyProfile profile = service.generateAndSaveProfile(user);

        assertNotNull(profile);
        assertEquals(6, profile.getDestinyNumber());
        assertEquals(11, profile.getSoulUrgeNumber());
        assertEquals(7, profile.getPersonalityNumber());
        assertEquals(6, profile.getMaturityNumber());
        assertEquals(9, profile.getExpressionNumber());
    }
}