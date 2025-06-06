package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.sensor.SensorDTO;
import br.com.fiap.harvestime.dto.sensor.SensorUpdateDTO;
import br.com.fiap.harvestime.entity.farm.Farm;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sensors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sensor")
    private Long id;

    private String name;
    private String model;
    private String unit;
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_farm")
    private Farm farm;

    public Sensor(Long idSensor) {
        this.id = idSensor;
    }

    public Sensor(SensorDTO sensorDTO) {
        this.name = sensorDTO.name();
        this.model = sensorDTO.model();
        this.unit = sensorDTO.unit();
        this.farm = new Farm(sensorDTO.idFarm());
        this.active = true;
    }

    public void update(@Valid SensorUpdateDTO sensorUpdateDTO) {
        if (sensorUpdateDTO.name() != null) {
            this.name = sensorUpdateDTO.name();
        }
        if (sensorUpdateDTO.unit() != null) {
            this.unit = sensorUpdateDTO.unit();
        }
        if (sensorUpdateDTO.idFarm() != null) {
            this.farm = new Farm(sensorUpdateDTO.idFarm());
        }
    }
}
