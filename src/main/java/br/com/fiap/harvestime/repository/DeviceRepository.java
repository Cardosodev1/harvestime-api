package br.com.fiap.harvestime.repository;

import br.com.fiap.harvestime.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
