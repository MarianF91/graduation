package com.example.service;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.ProfileDto;
import com.example.dto.UserDto;
import com.example.exception.ProfileNotFoundException;
import com.example.mapper.NumerologyMapper;
import com.example.mapper.UserMapper;
import com.example.model.NumerologyProfile;
import com.example.model.User;
import com.example.repository.ProfileRepository;
import com.example.repository.UserRepository;
import com.example.utils.NumerologyCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumerologyServiceImplTest {

    @Mock private UserRepository userRepository;
    @Mock private ProfileRepository profileRepository;
    @Mock private UserMapper userMapper;
    @Mock private NumerologyMapper numerologyMapper;

    @InjectMocks
    private NumerologyServiceImpl service;

    private final UserDto dto = new UserDto("Ana", "Pop", 1990, 5, 15);
    private final User user = new User("Ana", "Pop", 1990, 5, 15);

    @Test
    void calculateProfile_createsNewUserAndReturnsMappedResponse() {
        // a) no existing user → we save a new one
        when(userRepository
                .findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
                        dto.firstName(), dto.lastName(),
                        dto.birthYear(), dto.birthMonth(), dto.birthDay()))
                .thenReturn(Optional.empty());
        when(userMapper.toEntity(dto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        // b) generate & save profile
        NumerologyProfile generated = NumerologyCalculator.generateProfile(user);
        generated.setId(42L);
        when(profileRepository.save(any(NumerologyProfile.class)))
                .thenReturn(generated);

        // c) map to response
        NumerologyProfileResponse expected = new NumerologyProfileResponse(
                42L,
                new ProfileDto(generated.getLifePathNumber(),    "LP meaning"),
                new ProfileDto(generated.getDestinyNumber(),     "D meaning"),
                new ProfileDto(generated.getExpressionNumber(),  "EXP meaning"),
                new ProfileDto(generated.getSoulUrgeNumber(),    "SU meaning"),
                new ProfileDto(generated.getPersonalityNumber(), "P meaning"),
                new ProfileDto(generated.getBirthdayNumber(),    "B meaning"),
                new ProfileDto(generated.getMaturityNumber(),    "M meaning"),
                new ProfileDto(generated.getBalanceNumber(),     "BA meaning"),
                new ProfileDto(generated.getLessonNumber(),      "L meaning"),
                user.getFirstName(), user.getLastName()
        );

        when(numerologyMapper.toResponse(generated)).thenReturn(expected);

        // exercise
        NumerologyProfileResponse actual = service.calculateProfile(dto);

        // verify
        assertSame(expected, actual);
        InOrder inOrder = inOrder(userRepository, userMapper, profileRepository, numerologyMapper);
        inOrder.verify(userRepository).findByFirstNameAndLastNameAndBirthYearAndBirthMonthAndBirthDay(
                dto.firstName(), dto.lastName(),
                dto.birthYear(), dto.birthMonth(), dto.birthDay());
        inOrder.verify(userMapper).toEntity(dto);
        inOrder.verify(userRepository).save(user);
        inOrder.verify(profileRepository).save(any(NumerologyProfile.class));
        inOrder.verify(numerologyMapper).toResponse(generated);
    }

    @Test
    void findProfile_existingId_returnsMappedResponse() {
        NumerologyProfile p = NumerologyCalculator.generateProfile(user);
        p.setId(100L);
        when(profileRepository.findById(100L)).thenReturn(Optional.of(p));

        NumerologyProfileResponse stub = new NumerologyProfileResponse(
                100L,
                new ProfileDto(p.getLifePathNumber(),    "any"),
                new ProfileDto(p.getDestinyNumber(),     "any"), // <--- ADD THIS
                new ProfileDto(p.getExpressionNumber(),  "any"),
                new ProfileDto(p.getSoulUrgeNumber(),    "any"),
                new ProfileDto(p.getPersonalityNumber(), "any"),
                new ProfileDto(p.getBirthdayNumber(),    "any"),
                new ProfileDto(p.getMaturityNumber(),    "any"),
                new ProfileDto(p.getBalanceNumber(),     "any"),
                new ProfileDto(p.getLessonNumber(),      "any"),
                user.getFirstName(), user.getLastName()
        );

        when(numerologyMapper.toResponse(p)).thenReturn(stub);

        NumerologyProfileResponse result = service.findProfile(100L);
        assertSame(stub, result);
    }

    @Test
    void findProfile_missingId_throws() {
        when(profileRepository.findById(999L)).thenReturn(Optional.empty());
        assertThrows(ProfileNotFoundException.class, () -> service.findProfile(999L));
    }

    @Test
    void findAllProfiles_mapsAll() {
        User u1 = new User("Ana", "Pop", 1990, 5, 15);
        User u2 = new User("Ion", "Ionescu", 1985, 6, 10);

        NumerologyProfile p1 = NumerologyCalculator.generateProfile(u1); p1.setId(1L);
        NumerologyProfile p2 = NumerologyCalculator.generateProfile(u2); p2.setId(2L);
        when(profileRepository.findAll()).thenReturn(List.of(p1, p2));

        NumerologyProfileResponse r1 = mock(NumerologyProfileResponse.class);
        NumerologyProfileResponse r2 = mock(NumerologyProfileResponse.class);
        when(numerologyMapper.toResponse(p1)).thenReturn(r1);
        when(numerologyMapper.toResponse(p2)).thenReturn(r2);

        var all = service.findAllProfiles();
        assertEquals(2, all.size());
        assertSame(r1, all.get(0));
        assertSame(r2, all.get(1));
    }
}
