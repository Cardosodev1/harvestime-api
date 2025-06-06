package br.com.fiap.harvestime.controller;

import br.com.fiap.harvestime.dto.alert.AlertDTO;
import br.com.fiap.harvestime.dto.alert.AlertDetailsDTO;
import br.com.fiap.harvestime.entity.alert.Alert;
import br.com.fiap.harvestime.repository.AlertRepository;
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
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid AlertDTO alertDTO, UriComponentsBuilder uriBuilder) {
        var alert = new Alert(alertDTO);
        repository.save(alert);

        var uri = uriBuilder.path("/alerts/{id}").buildAndExpand(alert.getId()).toUri();

        return ResponseEntity.created(uri).body(new AlertDetailsDTO(alert));
    }

    @GetMapping
    public ResponseEntity<Page<AlertDetailsDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(AlertDetailsDTO::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var alert = repository.getReferenceById(id);
        return ResponseEntity.ok(new AlertDetailsDTO(alert));
    }

}
