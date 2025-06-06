package br.com.fiap.harvestime.dto.user;

import br.com.fiap.harvestime.entity.User;

public record UserDetailsDTO(Long id,
                             String name,
                             String email,
                             String password) {

    public UserDetailsDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

}
