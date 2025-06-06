package br.com.fiap.harvestime.repository;

import br.com.fiap.harvestime.entity.Threshold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThresholdRepository extends JpaRepository<Threshold, Long> {
}
