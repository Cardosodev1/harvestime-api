package br.com.fiap.harvestime.dto.reading;

import br.com.fiap.harvestime.entity.Reading;

import java.time.LocalDateTime;

public record ReadingDetailsDTO(Long id,
                                LocalDateTime dateTime,
                                Double value,
                                Long idSensor) {

    public ReadingDetailsDTO(Reading reading) {
        this(reading.getId(), reading.getDateTime(), reading.getValue(), reading.getSensor().getId());
    }

}
