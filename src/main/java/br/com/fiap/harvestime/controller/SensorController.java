package br.com.fiap.harvestime.controller;

import br.com.fiap.harvestime.dto.sensor.SensorDTO;
import br.com.fiap.harvestime.dto.sensor.SensorDetailsDTO;
import br.com.fiap.harvestime.dto.sensor.SensorUpdateDTO;
import br.com.fiap.harvestime.entity.Sensor;
import br.com.fiap.harvestime.repository.SensorRepository;
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
@RequestMapping("/sensors")
public class SensorController {

    @Autowired
    private SensorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid SensorDTO sensorDTO, UriComponentsBuilder uriBuilder) {
        var sensor = new Sensor(sensorDTO);
        repository.save(sensor);

        var uri = uriBuilder.path("/sensors/{id}").buildAndExpand(sensor.getId()).toUri();

        return ResponseEntity.created(uri).body(new SensorDetailsDTO(sensor));
    }

    @GetMapping
    public ResponseEntity<Page<SensorDetailsDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(SensorDetailsDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid SensorUpdateDTO sensorUpdateDTO) {
        var sensor = repository.getReferenceById(sensorUpdateDTO.id());
        sensor.update(sensorUpdateDTO);

        return ResponseEntity.ok(new SensorDetailsDTO(sensor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var sensor = repository.getReferenceById(id);
        return ResponseEntity.ok(new SensorDetailsDTO(sensor));
    }

}
