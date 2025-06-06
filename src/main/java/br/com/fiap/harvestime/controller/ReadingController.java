package br.com.fiap.harvestime.controller;

import br.com.fiap.harvestime.dto.reading.ReadingDTO;
import br.com.fiap.harvestime.dto.reading.ReadingDetailsDTO;
import br.com.fiap.harvestime.entity.Reading;
import br.com.fiap.harvestime.repository.ReadingRepository;
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
@RequestMapping("/readings")
public class ReadingController {

    @Autowired
    private ReadingRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid ReadingDTO readingDTO, UriComponentsBuilder uriBuilder) {
        var reading = new Reading(readingDTO);
        repository.save(reading);

        var uri = uriBuilder.path("/readings/{id}").buildAndExpand(reading.getId()).toUri();

        return ResponseEntity.created(uri).body(new ReadingDetailsDTO(reading));
    }

    @GetMapping
    public ResponseEntity<Page<ReadingDetailsDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(ReadingDetailsDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ReadingDetailsDTO readingDetailsDTO) {
        var reading = repository.getReferenceById(readingDetailsDTO.id());
        reading.update(readingDetailsDTO);

        return ResponseEntity.ok(new ReadingDetailsDTO(reading));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var reading = repository.getReferenceById(id);
        return ResponseEntity.ok(new ReadingDetailsDTO(reading));
    }

}
