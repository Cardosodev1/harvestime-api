package br.com.fiap.harvestime.dto.device;

import jakarta.validation.constraints.NotNull;

public record DeviceUpdateDTO(

        @NotNull
        Long id,

        String name,
        Long farmId

) {
}
