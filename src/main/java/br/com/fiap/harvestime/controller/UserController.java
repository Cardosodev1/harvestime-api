package br.com.fiap.harvestime.controller;

import br.com.fiap.harvestime.dto.user.UserDTO;
import br.com.fiap.harvestime.dto.user.UserDetailsDTO;
import br.com.fiap.harvestime.dto.user.UserListDTO;
import br.com.fiap.harvestime.dto.user.UserUpdateDTO;
import br.com.fiap.harvestime.entity.User;
import br.com.fiap.harvestime.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriBuilder) {
        var user = new User(userDTO);
        repository.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetailsDTO(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserListDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(UserListDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UserUpdateDTO userUpdateDTO) {
        var user = repository.getReferenceById(userUpdateDTO.id());
        user.update(userUpdateDTO);

        return ResponseEntity.ok(new UserDetailsDTO(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailsDTO(user));
    }

}
