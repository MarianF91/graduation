package com.example.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class NumerologyMeaningId implements Serializable {
    public NumerologyMeaningId() {
    }

    @Serial
    private static final long serialVersionUID = 1L;

    private int number;
    private MeaningType type;

    public NumerologyMeaningId(int number, MeaningType type) {
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