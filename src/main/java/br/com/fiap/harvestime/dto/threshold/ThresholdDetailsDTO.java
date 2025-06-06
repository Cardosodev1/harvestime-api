package br.com.fiap.harvestime.dto.threshold;

import br.com.fiap.harvestime.entity.Threshold;

public record ThresholdDetailsDTO(Long id,
                                  Double minValue,
                                  Double maxValue,
                                  Long idSensor) {

    public ThresholdDetailsDTO(Threshold threshold) {
        this(threshold.getId(), threshold.getMinValue(), threshold.getMaxValue(), threshold.getSensor().getId());
    }

}
