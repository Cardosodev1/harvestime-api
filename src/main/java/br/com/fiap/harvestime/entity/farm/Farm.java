package br.com.fiap.harvestime.entity.farm;

import br.com.fiap.harvestime.dto.farm.FarmDTO;
import br.com.fiap.harvestime.dto.farm.FarmDetailsDTO;
import br.com.fiap.harvestime.entity.Address;
import br.com.fiap.harvestime.entity.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farms")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_farm")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Land land;

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public Farm(Long idFarm) {
        this.id = idFarm;
    }

    public Farm(FarmDTO farmDTO) {
        this.name = farmDTO.name();
        this.land = farmDTO.land();
        this.address = new Address(farmDTO.address());
        this.user = new User(farmDTO.idUser());
    }

    public void update(@Valid FarmDetailsDTO farmDetailsDTO) {
        if (farmDetailsDTO.name() != null) {
            this.name = farmDetailsDTO.name();
        }
        if (farmDetailsDTO.land() != null) {
            this.land = farmDetailsDTO.land();
        }
        if (farmDetailsDTO.idUser() != null) {
            this.user = new User(farmDetailsDTO.idUser());
        }
    }
}
