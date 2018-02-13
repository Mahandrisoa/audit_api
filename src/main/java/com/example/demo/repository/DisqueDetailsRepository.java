package com.example.demo.repository;


import com.example.demo.model.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisqueDetailsRepository extends JpaRepository<Materiel,Long> {
    @Query( value =
            "SELECT NOM_DISQUE, ESPACE_TOTAL, ESPACE_LIBRE,serveur,TO_char( DATE_AUDIT_JOURNALIER,'DD/MM/YYYY HH24:MI:SS'),DIVISION " +
            "FROM audit_journalier_disque_detail " +
            "WHERE DATE_AUDIT_JOURNALIER = " +
            "(   SELECT MAX(DATE_AUDIT_JOURNALIER) FROM " +
            "    (" +
            "        SELECT * FROM audit_journalier_disque_detail WHERE DIVISION= ?1 " +
            "        AND TO_CHAR(DATE_AUDIT_JOURNALIER,'DD/MM/YYYY') = ?2" +
            "   )" +
            ")"
            ,nativeQuery = true)
    List<Object> findDisqueDetails(String division, String date);
}
