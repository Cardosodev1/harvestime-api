package br.com.fiap.harvestime.dto.device;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DeviceDTO(

        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        String model,

        @NotNull
        Long farmId

) {
}
