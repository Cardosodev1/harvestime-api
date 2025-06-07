package br.com.fiap.harvestime.dto.reading;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReadingDTO(

    @NotNull
    LocalDateTime dateTime,

    Double temperature,
    Double humidity,

    @NotNull
    Long sensorId

) {
}
