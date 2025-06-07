package br.com.fiap.harvestime.dto.alert;

import br.com.fiap.harvestime.entity.alert.Alert;
import br.com.fiap.harvestime.entity.alert.Severity;

import java.time.LocalDateTime;

public record AlertDetailsDTO(Long id,
                              String message,
                              LocalDateTime dateTime,
                              Severity severity,
                              Long sensorId) {

    public AlertDetailsDTO(Alert alert) {
        this(alert.getId(), alert.getMessage(), alert.getDateTime(), alert.getSeverity(), alert.getSensor().getId());
    }

}
