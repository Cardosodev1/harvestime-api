package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.reading.ReadingDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reading")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reading_id")
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    private Double temperature;
    private Double humidity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public Reading(ReadingDTO readingDTO) {
        this.dateTime = readingDTO.dateTime();
        this.temperature = readingDTO.temperature();
        this.humidity = readingDTO.humidity();
        this.sensor = new Sensor(readingDTO.sensorId());
    }
}
