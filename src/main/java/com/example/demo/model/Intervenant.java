package com.example.demo.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "intervenant")
@EntityListeners(AuditingEntityListener.class)
public class Intervenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String numero;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @DecimalMax("50000")
    private BigDecimal tauxHoraire;

    public BigDecimal getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(BigDecimal tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


}
