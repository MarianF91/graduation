package com.example.mapper;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.UserDto;
import com.example.model.MeaningType;
import com.example.model.NumerologyProfile;
import com.example.model.User;
import com.example.service.MeaningService;
import org.springframework.stereotype.Component;

@Component
public class NumerologyMapper {

    private final MeaningService meaningService;

    public NumerologyMapper(MeaningService meaningService) {
        this.meaningService = meaningService;
    }

    public User toEntity(UserDto dto) {
        return new User(
                dto.firstName(),
                dto.lastName(),
                dto.birthYear(),
                dto.birthMonth(),
                dto.birthDay()
        );
    }

    public NumerologyProfileResponse toDto(NumerologyProfile profile) {
        return new NumerologyProfileResponse(
                profile.getId(),
                profile.getDestinyNumber(),
                meaningService.getMeaning(profile.getDestinyNumber(), MeaningType.DESTINY),
                profile.getSoulUrgeNumber(),
                meaningService.getMeaning(profile.getSoulUrgeNumber(), MeaningType.SOUL_URGE),
                profile.getPersonalityNumber(),
                meaningService.getMeaning(profile.getPersonalityNumber(), MeaningType.PERSONALITY),
                profile.getExpressionNumber(),
                meaningService.getMeaning(profile.getExpressionNumber(), MeaningType.EXPRESSION),
                profile.getMaturityNumber(),
                meaningService.getMeaning(profile.getMaturityNumber(), MeaningType.MATURITY),
                profile.getUser().getFirstName(),
                profile.getUser().getLastName()
        );
    }
}
