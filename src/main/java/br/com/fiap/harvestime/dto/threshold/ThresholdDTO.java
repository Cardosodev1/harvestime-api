package br.com.fiap.harvestime.dto.threshold;

import jakarta.validation.constraints.NotNull;

public record ThresholdDTO(

        @NotNull
        Double minValue,

        @NotNull
        Double maxValue,

        @NotNull
        Long idSensor

) {
}
