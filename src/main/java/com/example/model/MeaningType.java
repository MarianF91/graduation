package com.example.model;

public enum MeaningType {
    DESTINY("destiny"),
    SOUL_URGE("soulUrge"),
    PERSONALITY("personality"),
    EXPRESSION("expression"),
    MATURITY("maturity");

    private final String dbValue;

    MeaningType(String dbValue) {
        this.dbValue = dbValue;
    }

    public String dbValue() {
        return dbValue;
    }
}