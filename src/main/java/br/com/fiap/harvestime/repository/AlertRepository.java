package br.com.fiap.harvestime.repository;

import br.com.fiap.harvestime.entity.alert.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}
