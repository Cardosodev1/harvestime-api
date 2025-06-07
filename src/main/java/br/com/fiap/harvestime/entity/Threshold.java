package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.threshold.ThresholdDTO;
import br.com.fiap.harvestime.dto.threshold.ThresholdDetailsDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "threshold")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Threshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "threshold_id")
    private Long id;

    @Column(name = "min_temp")
    private Double minTemperature;

    @Column(name = "max_temp")
    private Double maxTemperature;

    @Column(name = "min_humid")
    private Double minHumidity;

    @Column(name = "max_humid")
    private Double maxHumidity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public Threshold(ThresholdDTO thresholdDTO) {
        this.minTemperature = thresholdDTO.minTemperature();
        this.maxTemperature = thresholdDTO.maxTemperature();
        this.minHumidity = thresholdDTO.minHumidity();
        this.maxHumidity = thresholdDTO.maxHumidity();
        this.sensor = new Sensor(thresholdDTO.sensorId());
    }

    public void update(@Valid ThresholdDetailsDTO thresholdDetailsDTO) {
        if (thresholdDetailsDTO.minTemperature() != null) {
            this.minTemperature = thresholdDetailsDTO.minTemperature();
        }
        if (thresholdDetailsDTO.maxTemperature() != null) {
            this.maxTemperature = thresholdDetailsDTO.maxTemperature();
        }
        if (thresholdDetailsDTO.minHumidity() != null) {
            this.minHumidity = thresholdDetailsDTO.minHumidity();
        }
        if (thresholdDetailsDTO.maxHumidity() != null) {
            this.maxHumidity = thresholdDetailsDTO.maxHumidity();
        }
        if (thresholdDetailsDTO.sensorId() != null) {
            this.sensor = new Sensor(thresholdDetailsDTO.sensorId());
        }
    }
}
