package br.com.fiap.harvestime.dto.reading;

import br.com.fiap.harvestime.entity.Reading;

import java.time.LocalDateTime;

public record ReadingDetailsDTO(Long id,
                                LocalDateTime dateTime,
                                Double temperature,
                                Double humidity,
                                Long sensorId) {

    public ReadingDetailsDTO(Reading reading) {
        this(reading.getId(), reading.getDateTime(), reading.getTemperature(), reading.getHumidity(), reading.getSensor().getId());
    }

}
