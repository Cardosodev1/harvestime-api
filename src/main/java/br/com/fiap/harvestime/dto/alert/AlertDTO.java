package br.com.fiap.harvestime.dto.alert;

import br.com.fiap.harvestime.entity.alert.Severity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AlertDTO(

        @NotNull
        @NotBlank
        String message,

        @NotNull
        LocalDateTime dateTime,

        @NotNull
        Severity severity,

        @NotNull
        Long idSensor,

        @NotNull
        Long idFarm

) {
}
