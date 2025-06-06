package br.com.fiap.harvestime.repository;

import br.com.fiap.harvestime.entity.farm.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
