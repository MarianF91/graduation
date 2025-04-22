package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "numerology_meaning")
@Access(AccessType.FIELD)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class NumerologyMeaning {

    @EmbeddedId
    private NumerologyMeaningId id;

    @Column(name = "description", nullable = false)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumerologyMeaning that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}