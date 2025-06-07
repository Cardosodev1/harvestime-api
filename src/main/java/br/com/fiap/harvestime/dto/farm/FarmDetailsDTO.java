package br.com.fiap.harvestime.dto.farm;

import br.com.fiap.harvestime.entity.Address;
import br.com.fiap.harvestime.entity.farm.Farm;
import br.com.fiap.harvestime.entity.farm.Land;

public record FarmDetailsDTO(Long id,
                             String name,
                             Land land,
                             Address address,
                             Long userId) {

    public FarmDetailsDTO(Farm farm) {
        this(farm.getId(), farm.getName(), farm.getLand(), farm.getAddress(), farm.getUser().getId());
    }

}
