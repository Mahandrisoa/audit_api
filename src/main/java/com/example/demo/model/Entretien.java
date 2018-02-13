package com.example.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "entretien")
@EntityListeners(AuditingEntityListener.class)
public class Entretien implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn( name = "id")
    private Long id;

    @ManyToOne
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "intervenant_id")
    private Intervenant intervenant;

    @ManyToOne
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn( name = "materiel_id")
    private Materiel materiel;

    @NotNull
    private Date dateEntretien;

    private BigDecimal nbHeure;

    public BigDecimal getNbHeure() {
        return nbHeure;
    }

    public void setNbHeure(BigDecimal nbHeure) {
        this.nbHeure = nbHeure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public Date getDateEntretien() {
        return dateEntretien;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public void setDateEntretien(Date dateEntretien) {
        this.dateEntretien = dateEntretien;
    }
}
