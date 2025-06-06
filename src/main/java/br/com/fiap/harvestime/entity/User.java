package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.user.UserDTO;
import br.com.fiap.harvestime.dto.user.UserUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    private String name;
    private String email;
    private String password;

    public User(Long idUser) {
        this.id = idUser;
    }

    public User(UserDTO userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
    }

    public void update(@Valid UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO.name() != null) {
            this.name = userUpdateDTO.name();
        }
        if (userUpdateDTO.password() != null) {
            this.password = userUpdateDTO.password();
        }
    }
}
