package com.example.demo.controller;

import com.example.demo.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AuditController {
    @Autowired
    AuditRepository auditRepository;

    @GetMapping("/audits")
    public ResponseEntity<Object> getRecentAudits(@RequestParam String date) {
        List<Object> resultSet = auditRepository.findRecentAudits(date);
        if (resultSet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(resultSet);
    }
}
