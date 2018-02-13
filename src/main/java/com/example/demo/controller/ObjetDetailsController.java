package com.example.demo.controller;

import com.example.demo.repository.ObjetDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ObjetDetailsController {
    @Autowired
    ObjetDetailsRepository objetDetailsRepository;

    @GetMapping("/objet_details")
    public ResponseEntity<Object> getObjetDetails(@RequestParam (name = "division") String division, @RequestParam (name = "date") String date, @RequestParam(name = "objet") String objet) {
        List<Object> resultSet = objetDetailsRepository.findObjetDetails(division,date,objet);
        if(resultSet == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(resultSet);
    }
}
