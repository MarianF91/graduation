package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class NumerologyMeaningId implements Serializable {
    private int number;
    private String type;

    public NumerologyMeaningId() {}

    public NumerologyMeaningId(int number, String type) {
        this.number = number;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumerologyMeaningId that)) return false;
        return number == that.number && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }
}