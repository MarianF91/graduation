package com.example.service;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.exception.ProfileNotFoundException;
import com.example.mapper.NumerologyMapper;
import com.example.model.MeaningType;
import com.example.model.NumerologyProfile;
import com.example.model.User;
import com.example.repository.ProfileRepository;
import com.example.repository.UserRepository;
import com.example.utils.NumerologyCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class NumerologyServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ProfileRepository profileRepository;
    @Mock
    private MeaningService meaningService;

    @InjectMocks
    private NumerologyServiceImpl service;

    private UserDto dto;
    private User user;

    @BeforeEach
    void setUp() {
        NumerologyMapper mapper = new NumerologyMapper(meaningService);
        service = new NumerologyServiceImpl(userRepository, profileRepository, mapper);

        dto = new UserDto("Ana", "Pop", 1990, 5, 15);
        user = new User("Ana", "Pop", 1990, 5, 15);
    }

    @Test
    void generateAndSaveProfile_returnsCorrectResponse() {
        NumerologyProfile profile = NumerologyCalculator.generateProfile(user);
        profile.setId(1L);
        profile.setUser(user);

        when(userRepository.findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
                "Ana", "Pop", 1990, 5, 15)).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(profileRepository.save(any(NumerologyProfile.class))).thenReturn(profile);

        when(meaningService.getMeaning(anyInt(), eq(MeaningType.DESTINY))).thenReturn("Destiny meaning");
        when(meaningService.getMeaning(anyInt(), eq(MeaningType.SOUL_URGE))).thenReturn("SoulUrge meaning");
        when(meaningService.getMeaning(anyInt(), eq(MeaningType.PERSONALITY))).thenReturn("Personality meaning");
        when(meaningService.getMeaning(anyInt(), eq(MeaningType.EXPRESSION))).thenReturn("Expression meaning");
        when(meaningService.getMeaning(anyInt(), eq(MeaningType.MATURITY))).thenReturn("Maturity meaning");

        NumerologyProfileResponse result = service.generateAndSaveProfile(dto);

        assertNotNull(result);
        assertEquals("Ana", result.firstName());
        assertEquals("Pop", result.lastName());
        assertEquals("Destiny meaning", result.destinyMeaning());
    }

    @Test
    void findProfile_returnsCorrectDto() {
        NumerologyProfile profile = NumerologyCalculator.generateProfile(user);
        profile.setId(1L);
        profile.setUser(user);

        when(profileRepository.findById(1L)).thenReturn(Optional.of(profile));
        when(meaningService.getMeaning(anyInt(), any())).thenReturn("Meaning");

        NumerologyProfileResponse result = service.findProfile(1L);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals("Ana", result.firstName());
        assertEquals("Pop", result.lastName());
    }

    @Test
    void findProfile_throwsExceptionIfNotFound() {
        when(profileRepository.findById(99L)).thenReturn(Optional.empty());

        Exception ex = assertThrows(ProfileNotFoundException.class,
                () -> service.findProfile(99L));

        assertEquals("Profile not found with id: 99", ex.getMessage());
    }

    @Test
    void findAllProfiles_returnsListOfDtos() {
        User user1 = new User("Ana", "Pop", 1990, 5, 15);
        User user2 = new User("Ion", "Ionescu", 1985, 6, 10);

        NumerologyProfile profile1 = NumerologyCalculator.generateProfile(user1);
        profile1.setId(1L);
        profile1.setUser(user1);

        NumerologyProfile profile2 = NumerologyCalculator.generateProfile(user2);
        profile2.setId(2L);
        profile2.setUser(user2);

        when(meaningService.getMeaning(anyInt(), any())).thenReturn("Meaning");
        when(profileRepository.findAll()).thenReturn(List.of(profile1, profile2));

        List<NumerologyProfileResponse> result = service.findAllProfiles();

        assertEquals(2, result.size());

        NumerologyProfileResponse ana = result.stream()
                .filter(r -> r.firstName().equals("Ana")).findFirst().orElseThrow();
        NumerologyProfileResponse ion = result.stream()
                .filter(r -> r.firstName().equals("Ion")).findFirst().orElseThrow();

        assertEquals("Ana", ana.firstName());
        assertEquals("Ion", ion.firstName());
    }
}