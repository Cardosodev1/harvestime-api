package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.reading.ReadingDTO;
import br.com.fiap.harvestime.dto.reading.ReadingDetailsDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "readings")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reading")
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sensor")
    private Sensor sensor;

    public Reading(ReadingDTO readingDTO) {
        this.dateTime = readingDTO.dateTime();
        this.value = readingDTO.value();
        this.sensor = new Sensor(readingDTO.idSensor());
    }


    public void update(@Valid ReadingDetailsDTO readingDetailsDTO) {
        if (readingDetailsDTO.dateTime() != null) {
            this.dateTime = readingDetailsDTO.dateTime();
        }
        if (readingDetailsDTO.value() != null) {
            this.value = readingDetailsDTO.value();
        }
        if (readingDetailsDTO.idSensor() != null) {
            this.sensor = new Sensor(readingDetailsDTO.idSensor());
        }
    }
}
