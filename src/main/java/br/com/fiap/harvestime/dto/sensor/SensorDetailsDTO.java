package br.com.fiap.harvestime.dto.sensor;

import br.com.fiap.harvestime.entity.Sensor;

public record SensorDetailsDTO(Long id,
                               String name,
                               String model,
                               String unit,
                               Long idFarm) {

    public SensorDetailsDTO(Sensor sensor) {
        this(sensor.getId(), sensor.getName(), sensor.getModel(), sensor.getUnit(), sensor.getFarm().getId());
    }

}
