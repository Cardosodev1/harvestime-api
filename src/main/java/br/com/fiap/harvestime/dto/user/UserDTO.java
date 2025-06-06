package br.com.fiap.harvestime.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(

        @NotNull
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotNull
        @NotBlank
        String password

) {
}
