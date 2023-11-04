package com.esprit.kaddem.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Universite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniversite;
    private String nomUniv;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Departement> departements;

    public Universite(Integer idUniversite, String nomUniv) {
        this.idUniversite = idUniversite;
        this.nomUniv = nomUniv;
    }

    public Integer getIdUniversite() {
        return idUniversite;
    }

    public void setIdUniversite(Integer idUniversite) {
        this.idUniversite = idUniversite;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }
}
