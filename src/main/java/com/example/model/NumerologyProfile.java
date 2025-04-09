package com.example.graduation.model;

public class NumerologyProfile {
    private final int destinyNumber;
    private final int soulNumber;
    private final int personalityNumber;
    private final int maturityNumber;
    private final int expressionNumber;
    private final int birthYear;
    private final String destinyDescription;
    private final String soulDescription;
    private final String personalityDescription;
    private final String maturityDescription;
    private final String expressionDescription;

    public NumerologyProfile(int destiny, int soul, int personality, int maturity, int expression,
                             int birthYear, String destinyDescription, String soulDescription,
                             String personalityDescription, String maturityDescription, String expressionDescription) {
        this.destinyNumber = destiny;
        this.soulNumber = soul;
        this.personalityNumber = personality;
        this.maturityNumber = maturity;
        this.expressionNumber = expression;
        this.birthYear = birthYear;
        this.destinyDescription = destinyDescription;
        this.soulDescription = soulDescription;
        this.personalityDescription = personalityDescription;
        this.maturityDescription = maturityDescription;
        this.expressionDescription = expressionDescription;

    }

    public int getDestinyNumber() {
        return destinyNumber;
    }

    public int getSoulNumber() {
        return soulNumber;
    }

    public int getPersonalityNumber() {
        return personalityNumber;
    }

    public int getMaturityNumber() {
        return maturityNumber;
    }

    public int getExpressionNumber() {
        return expressionNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getDestinyDescription() {
        return destinyDescription;
    }

    public String getSoulDescription() {
        return soulDescription;
    }

    public String getPersonalityDescription() {
        return personalityDescription;
    }

    public String getMaturityDescription() {
        return maturityDescription;
    }

    public String getExpressionDescription() {
        return expressionDescription;
    }

}
