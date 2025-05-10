package com.example.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public final class NumerologyMeaningId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int number;
    private MeaningType type;

}