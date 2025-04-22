package com.example.model;

import lombok.Getter;

@Getter
public enum MeaningType {
    LIFE_PATH("life_path"),
    EXPRESSION("expression"),
    SOUL_URGE("soul_urge"),
    PERSONALITY("personality"),
    BIRTHDAY("birthday"),
    MATURITY("maturity"),
    BALANCE("balance"),
    LESSON("lesson"),
    DESTINY("destiny");

    private final String dbValue;

    MeaningType(String dbValue) {
        this.dbValue = dbValue;
    }
}
