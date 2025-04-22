package com.example.mapper;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.ProfileDto;
import com.example.model.MeaningType;
import com.example.model.NumerologyProfile;
import com.example.service.MeaningService;
import org.springframework.stereotype.Component;

@Component
public class NumerologyMapper {

    private final MeaningService meaningService;

    public NumerologyMapper(MeaningService meaningService) {

        this.meaningService = meaningService;
    }

    public NumerologyProfileResponse toDto(NumerologyProfile profile) {

        ProfileDto destiny = new ProfileDto(
                profile.getDestinyNumber(),
                meaningService.getMeaning(profile.getDestinyNumber(), MeaningType.DESTINY)
        );
        ProfileDto soulUrge = new ProfileDto(
                profile.getSoulUrgeNumber(),
                meaningService.getMeaning(profile.getSoulUrgeNumber(), MeaningType.SOUL_URGE)
        );
        ProfileDto personality = new ProfileDto(
                profile.getPersonalityNumber(),
                meaningService.getMeaning(profile.getPersonalityNumber(), MeaningType.PERSONALITY)
        );
        ProfileDto expression = new ProfileDto(
                profile.getExpressionNumber(),
                meaningService.getMeaning(profile.getExpressionNumber(), MeaningType.EXPRESSION)
        );
        ProfileDto maturity = new ProfileDto(
                profile.getMaturityNumber(),
                meaningService.getMeaning(profile.getMaturityNumber(), MeaningType.MATURITY)
        );

        return new NumerologyProfileResponse(
                profile.getId(),
                destiny,
                soulUrge,
                personality,
                expression,
                maturity,
                profile.getUser().getFirstName(),
                profile.getUser().getLastName()
        );
    }
}