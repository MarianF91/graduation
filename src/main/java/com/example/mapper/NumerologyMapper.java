package com.example.mapper;

import com.example.dto.NumerologyProfileResponse;
import com.example.dto.ProfileDto;
import com.example.model.MeaningType;
import com.example.model.NumerologyProfile;
import com.example.service.MeaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumerologyMapper {

    private final MeaningService meaningService;

    public NumerologyProfileResponse toResponse(NumerologyProfile p) {
        String firstName = p.getUser().getFirstName();
        String lastName = p.getUser().getLastName();

        return new NumerologyProfileResponse(
                p.getId(),
                new ProfileDto(p.getDestinyNumber(),
                        meaningService.getMeaning(p.getDestinyNumber(), MeaningType.DESTINY)),
                new ProfileDto(p.getLifePathNumber(),
                        meaningService.getMeaning(p.getLifePathNumber(), MeaningType.LIFE_PATH)),
                new ProfileDto(p.getExpressionNumber(),
                        meaningService.getMeaning(p.getExpressionNumber(), MeaningType.EXPRESSION)),
                new ProfileDto(p.getSoulUrgeNumber(),
                        meaningService.getMeaning(p.getSoulUrgeNumber(), MeaningType.SOUL_URGE)),
                new ProfileDto(p.getPersonalityNumber(),
                        meaningService.getMeaning(p.getPersonalityNumber(), MeaningType.PERSONALITY)),
                new ProfileDto(p.getBirthdayNumber(),
                        meaningService.getMeaning(p.getBirthdayNumber(), MeaningType.BIRTHDAY)),
                new ProfileDto(p.getMaturityNumber(),
                        meaningService.getMeaning(p.getMaturityNumber(), MeaningType.MATURITY)),
                new ProfileDto(p.getBalanceNumber(),
                        meaningService.getMeaning(p.getBalanceNumber(), MeaningType.BALANCE)),
                new ProfileDto(p.getLessonNumber(),
                        meaningService.getMeaning(p.getLessonNumber(), MeaningType.LESSON)),
                firstName,
                lastName
        );
    }
}
