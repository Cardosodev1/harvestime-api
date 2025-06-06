package br.com.fiap.harvestime.dto.user;

import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(

        @NotNull
        Long id,

        String name,
        String password

) {
}
