package com.example.demo.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "materiel")
@EntityListeners(AuditingEntityListener.class)
public class Materiel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Ce champ doit être rempli.")
    @Column(unique = true)
    private String numero;

    @NotBlank(message = "Ce champ doit être rempli.")
    private String Libelle;

    @NotBlank(message = "Ce champ doit être rempli.")
    private String etat;

    @OneToMany( mappedBy = "materiel")
    private Set<Entretien> entretiens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
