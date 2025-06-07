package br.com.fiap.harvestime.dto.device;

import br.com.fiap.harvestime.entity.Device;

public record DeviceDetailsDTO(Long id,
                               String name,
                               String model,
                               Long farmId) {

    public DeviceDetailsDTO(Device device) {
        this(device.getId(), device.getName(), device.getModel(), device.getFarm().getId());
    }

}
