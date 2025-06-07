package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.sensor.SensorDTO;
import br.com.fiap.harvestime.dto.sensor.SensorUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sensor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long id;

    @Column(name = "sensor_name")
    private String name;

    @Column(name = "sensor_model", unique = true)
    private String model;

    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    public Sensor(Long sensorId) {
        this.id = sensorId;
    }

    public Sensor(SensorDTO sensorDTO) {
        this.name = sensorDTO.name();
        this.model = sensorDTO.model();
        this.active = sensorDTO.active();
        this.device = new Device(sensorDTO.deviceId());
    }

    public void update(@Valid SensorUpdateDTO sensorUpdateDTO) {
        if (sensorUpdateDTO.name() != null) {
            this.name = sensorUpdateDTO.name();
        }
        if (sensorUpdateDTO.active() != null) {
            this.active = sensorUpdateDTO.active();
        }
        if (sensorUpdateDTO.deviceId() != null) {
            this.device = new Device(sensorUpdateDTO.deviceId());
        }
    }
}
