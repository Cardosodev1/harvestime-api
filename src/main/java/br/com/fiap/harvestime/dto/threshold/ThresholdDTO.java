package br.com.fiap.harvestime.dto.threshold;

import jakarta.validation.constraints.NotNull;

public record ThresholdDTO(

        @NotNull
        Double minTemperature,

        @NotNull
        Double maxTemperature,

        @NotNull
        Double minHumidity,

        @NotNull
        Double maxHumidity,

        @NotNull
        Long sensorId

) {
}
