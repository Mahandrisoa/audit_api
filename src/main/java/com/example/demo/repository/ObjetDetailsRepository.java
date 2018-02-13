package com.example.demo.repository;


import com.example.demo.model.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetDetailsRepository extends JpaRepository<Materiel,Long>{
    @Query( value =
            "SELECT TYPE_OBJET,NOM_OBJET,TAILLE_OBJET,NB_EXTENT,TAILLE_UTILISE,DATE_AUDIT_JOURNALIER,DIVISION " +
                    "FROM AUDIT_JOURNALIER_OBJET_DETAIL "+
            "WHERE TO_CHAR(DATE_AUDIT_JOURNALIER, 'DD/MM/YYYY hh24:mi:ss') = ?2 " +
            "AND DIVISION= ?1 " +
            "AND TYPE_OBJET= ?3"
            ,nativeQuery = true)
    List<Object> findObjetDetails(String division,String date,String objet);
}
