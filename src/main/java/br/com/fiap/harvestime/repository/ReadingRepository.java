package br.com.fiap.harvestime.repository;

import br.com.fiap.harvestime.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
}
