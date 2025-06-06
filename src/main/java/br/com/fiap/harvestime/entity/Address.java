package br.com.fiap.harvestime.entity;

import br.com.fiap.harvestime.dto.address.AddressDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;

    @Column(name = "zip_code")
    private String zipCode;

    private String city;
    private String state;

    @Column(name = "number_")
    private String number;

    private String complement;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.street();
        this.neighborhood = addressDTO.neighborhood();
        this.zipCode = addressDTO.zipCode();
        this.city = addressDTO.city();
        this.state = addressDTO.state();
        this.number = addressDTO.number();
        this.complement = addressDTO.complement();
    }

}
