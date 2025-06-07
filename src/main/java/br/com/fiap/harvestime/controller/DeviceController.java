package br.com.fiap.harvestime.controller;

import br.com.fiap.harvestime.dto.device.DeviceDTO;
import br.com.fiap.harvestime.dto.device.DeviceDetailsDTO;
import br.com.fiap.harvestime.dto.device.DeviceUpdateDTO;
import br.com.fiap.harvestime.entity.Device;
import br.com.fiap.harvestime.repository.DeviceRepository;
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
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DeviceDTO deviceDTO, UriComponentsBuilder uriBuilder) {
        var device = new Device(deviceDTO);
        repository.save(device);

        var uri = uriBuilder.path("/devices/{id}").buildAndExpand(device.getId()).toUri();

        return ResponseEntity.created(uri).body(new DeviceDetailsDTO(device));
    }

    @GetMapping
    public ResponseEntity<Page<DeviceDetailsDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(DeviceDetailsDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DeviceUpdateDTO deviceUpdateDTO) {
        var device = repository.getReferenceById(deviceUpdateDTO.id());
        device.update(deviceUpdateDTO);

        return ResponseEntity.ok(new DeviceDetailsDTO(device));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var device = repository.getReferenceById(id);
        return ResponseEntity.ok(new DeviceDetailsDTO(device));
    }

}
