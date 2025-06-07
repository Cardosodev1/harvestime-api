package br.com.fiap.harvestime.dto.sensor;

import br.com.fiap.harvestime.entity.Sensor;

public record SensorDetailsDTO(Long id,
                               String name,
                               String model,
                               Boolean active,
                               Long deviceId) {

    public SensorDetailsDTO(Sensor sensor) {
        this(sensor.getId(), sensor.getName(), sensor.getModel(), sensor.getActive(), sensor.getDevice().getId());
    }

}
