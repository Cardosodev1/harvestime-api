package br.com.fiap.harvestime.entity.alert;

import br.com.fiap.harvestime.dto.alert.AlertDTO;
import br.com.fiap.harvestime.entity.Sensor;
import br.com.fiap.harvestime.entity.farm.Farm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Long id;

    private String message;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    private Boolean resolved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public Alert(AlertDTO alertDTO) {
        this.message = alertDTO.message();
        this.dateTime = alertDTO.dateTime();
        this.severity = alertDTO.severity();
        this.sensor = new Sensor(alertDTO.sensorId());
    }
}
