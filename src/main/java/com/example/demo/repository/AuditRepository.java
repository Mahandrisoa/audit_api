package com.example.demo.repository;


import com.example.demo.model.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuditRepository extends JpaRepository<Materiel,Long>{
    @Query( value =
            "select DIVISION_NAME ,DIVISION,DIVISION_TYPE, CACHE_HIT_RATIO, TO_CHAR(DATE_AUDIT_JOURNALIER,'DD/MM/YYYY hh24:mi:ss') DATE_AUDIT_JOURNALIER " +
                    "from ( select * from AUDIT_JOURNALIER where TO_CHAR( DATE_AUDIT_JOURNALIER ,'dd/mm/yyyy')= ?1 ) " +
                    "where date_audit_journalier = " +
                    "(select max(DATE_AUDIT_JOURNALIER) from (select * from AUDIT_JOURNALIER where TO_CHAR( DATE_AUDIT_JOURNALIER ,'dd/mm/yyyy')= ?1 ))",
            nativeQuery = true)
    List<Object> findRecentAudits(String date);
}
