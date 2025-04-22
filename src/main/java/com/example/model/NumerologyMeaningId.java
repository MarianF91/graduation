package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class NumerologyMeaningId implements Serializable {

    @Column(name = "number")
    private int number;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private MeaningType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumerologyMeaningId that)) return false;
        return number == that.number && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }
}
