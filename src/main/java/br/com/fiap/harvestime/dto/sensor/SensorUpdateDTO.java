package br.com.fiap.harvestime.dto.sensor;

import jakarta.validation.constraints.NotNull;

public record SensorUpdateDTO(

        @NotNull
        Long id,

        String name,
        Boolean active,
        Long deviceId

) {
}
