package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.device.DeviceDTO;
import br.com.fiap.harvestime.dto.device.DeviceUpdateDTO;
import br.com.fiap.harvestime.entity.farm.Farm;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "device")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long id;

    @Column(name = "device_name")
    private String name;

    @Column(name = "device_model", unique = true)
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    private Farm farm;

    public Device(Long deviceId) {
        this.id = deviceId;
    }

    public Device(DeviceDTO deviceDTO) {
        this.name = deviceDTO.name();
        this.model = deviceDTO.model();
        this.farm = new Farm(deviceDTO.farmId());
    }


    public void update(@Valid DeviceUpdateDTO deviceUpdateDTO) {
        if (deviceUpdateDTO.name() != null) {
            this.name = deviceUpdateDTO.name();
        }
        if (deviceUpdateDTO.farmId() != null) {
            this.farm = new Farm(deviceUpdateDTO.farmId());
        }
    }
}
