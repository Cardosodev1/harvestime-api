package br.com.fiap.harvestime.repository;

import br.com.fiap.harvestime.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
