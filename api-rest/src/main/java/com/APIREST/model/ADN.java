package com.APIREST.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "ADN")
@Setter
public class ADN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoADN;
    private Boolean esMutante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoADN() {
        return codigoADN;
    }

    public void setCodigoADN(String codigoADN) {
        this.codigoADN = codigoADN;
    }

    public Boolean getEsMutante() {
        return esMutante;
    }

    public void setEsMutante(Boolean esMutante) {
        this.esMutante = esMutante;
    }
}
