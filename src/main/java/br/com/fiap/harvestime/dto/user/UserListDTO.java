package br.com.fiap.harvestime.dto.user;

import br.com.fiap.harvestime.entity.User;

public record UserListDTO(Long id,
                          String name,
                          String email) {

    public UserListDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }

}
