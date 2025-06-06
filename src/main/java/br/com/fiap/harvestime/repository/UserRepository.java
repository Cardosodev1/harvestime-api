package br.com.fiap.harvestime.repository;

import br.com.fiap.harvestime.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
