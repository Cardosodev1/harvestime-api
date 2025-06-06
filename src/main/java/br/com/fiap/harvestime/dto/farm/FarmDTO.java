package br.com.fiap.harvestime.dto.farm;

import br.com.fiap.harvestime.dto.address.AddressDTO;
import br.com.fiap.harvestime.entity.farm.Land;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FarmDTO(

        @NotNull
        @NotBlank
        String name,

        @NotNull
        Land land,

        @NotNull
        @Valid
        AddressDTO address,

        @NotNull
        Long idUser

) {
}
