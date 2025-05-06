package com.example.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NumerologyMeaningId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int number;
    private MeaningType type;

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