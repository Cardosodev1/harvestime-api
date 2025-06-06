package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.threshold.ThresholdDTO;
import br.com.fiap.harvestime.dto.threshold.ThresholdDetailsDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "thresholds")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Threshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_threshold")
    private Long id;

    private Double minValue;
    private Double maxValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sensor")
    private Sensor sensor;

    public Threshold(ThresholdDTO thresholdDTO) {
        this.minValue = thresholdDTO.minValue();
        this.maxValue = thresholdDTO.maxValue();
        this.sensor = new Sensor(thresholdDTO.idSensor());
    }

    public void update(@Valid ThresholdDetailsDTO thresholdDetailsDTO) {
        if (thresholdDetailsDTO.minValue() != null) {
            this.minValue = thresholdDetailsDTO.minValue();
        }
        if (thresholdDetailsDTO.maxValue() != null) {
            this.maxValue = thresholdDetailsDTO.maxValue();
        }
        if (thresholdDetailsDTO.idSensor() != null) {
            this.sensor = new Sensor(thresholdDetailsDTO.idSensor());
        }
    }
}
