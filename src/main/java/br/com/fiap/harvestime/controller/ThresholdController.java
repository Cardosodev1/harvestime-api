package br.com.fiap.harvestime.controller;

import br.com.fiap.harvestime.dto.threshold.ThresholdDTO;
import br.com.fiap.harvestime.dto.threshold.ThresholdDetailsDTO;
import br.com.fiap.harvestime.entity.Threshold;
import br.com.fiap.harvestime.repository.ThresholdRepository;
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
@RequestMapping("/thresholds")
public class ThresholdController {

    @Autowired
    private ThresholdRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid ThresholdDTO thresholdDTO, UriComponentsBuilder uriBuilder) {
        var threshold = new Threshold(thresholdDTO);
        repository.save(threshold);

        var uri = uriBuilder.path("/thresholds/{id}").buildAndExpand(threshold.getId()).toUri();

        return ResponseEntity.created(uri).body(new ThresholdDetailsDTO(threshold));
    }

    @GetMapping
    public ResponseEntity<Page<ThresholdDetailsDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(ThresholdDetailsDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ThresholdDetailsDTO thresholdDetailsDTO) {
        var threshold = repository.getReferenceById(thresholdDetailsDTO.id());
        threshold.update(thresholdDetailsDTO);

        return ResponseEntity.ok(new ThresholdDetailsDTO(threshold));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var threshold = repository.getReferenceById(id);
        return ResponseEntity.ok(new ThresholdDetailsDTO(threshold));
    }

}
