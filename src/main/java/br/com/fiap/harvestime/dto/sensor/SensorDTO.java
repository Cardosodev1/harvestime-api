package br.com.fiap.harvestime.dto.sensor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SensorDTO(

        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        String model,

        @NotNull
        Boolean active,

        @NotNull
        Long deviceId

) {
}
