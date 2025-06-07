package br.com.fiap.harvestime.dto.threshold;

import br.com.fiap.harvestime.entity.Threshold;

public record ThresholdDetailsDTO(Long id,
                                  Double minTemperature,
                                  Double maxTemperature,
                                  Double minHumidity,
                                  Double maxHumidity,
                                  Long sensorId) {

    public ThresholdDetailsDTO(Threshold threshold) {
        this(threshold.getId(), threshold.getMinTemperature(), threshold.getMaxTemperature(), threshold.getMinHumidity(), threshold.getMaxHumidity(), threshold.getSensor().getId());
    }

}
