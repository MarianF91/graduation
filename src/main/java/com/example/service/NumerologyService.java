package com.example.graduation.service;

import com.example.graduation.utils.NumerologyCalculator;
import com.example.graduation.model.NumerologyProfile;
import com.example.graduation.model.User;

public class NumerologyService {
    public NumerologyProfile profileGenerator(User user) {
        String fullName = user.firstName() + " " + user.lastName();

        int destiny = NumerologyCalculator.calculateDestinyNumber(user.yearOfBirth(),
                user.monthOfBirth(), user.dayOfBirth());
        int soul = NumerologyCalculator.calculateSoulNumber(user.dayOfBirth());
        int personality = NumerologyCalculator.calculatePersonalityNumber(user.monthOfBirth());
        int maturity = NumerologyCalculator.calculateMaturityNumber(destiny, personality);
        int expression = NumerologyCalculator.calculateExpressionNumber(fullName);

        String destinyDescription = NumerologyCalculator.getDestinyDescription(destiny);
        String soulDescription = NumerologyCalculator.getSoulDescription(soul);
        String personalityDescription = NumerologyCalculator.getPersonalityDescription(personality);
        String maturityDescription = NumerologyCalculator.getMaturityDescription(maturity);
        String expressionDescription = NumerologyCalculator.getExpressionDescription(expression);

        return new NumerologyProfile(destiny, soul, personality, maturity, expression,
                user.yearOfBirth(), destinyDescription, soulDescription, personalityDescription,
                maturityDescription, expressionDescription);
    }
}