package br.com.fiap.harvestime.controller;

import br.com.fiap.harvestime.dto.farm.FarmDTO;
import br.com.fiap.harvestime.dto.farm.FarmDetailsDTO;
import br.com.fiap.harvestime.entity.farm.Farm;
import br.com.fiap.harvestime.repository.FarmRepository;
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
@RequestMapping("/farms")
public class FarmController {

    @Autowired
    private FarmRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid FarmDTO farmDTO, UriComponentsBuilder uriBuilder) {
        var farm = new Farm(farmDTO);
        repository.save(farm);

        var uri = uriBuilder.path("/farms/{id}").buildAndExpand(farm.getId()).toUri();

        return ResponseEntity.created(uri).body(new FarmDetailsDTO(farm));
    }

    @GetMapping
    public ResponseEntity<Page<FarmDetailsDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(FarmDetailsDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid FarmDetailsDTO farmDetailsDTO) {
        var farm = repository.getReferenceById(farmDetailsDTO.id());
        farm.update(farmDetailsDTO);

        return ResponseEntity.ok(new FarmDetailsDTO(farm));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var farm = repository.getReferenceById(id);
        return ResponseEntity.ok(new FarmDetailsDTO(farm));
    }

}
