package com.example.demo.controller;

import com.example.demo.repository.DisqueDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DisqueDetailsController {
    @Autowired
    DisqueDetailsRepository disqueDetailsRepository;

    @GetMapping("/disque_details")
    public ResponseEntity<Object> getDisqueDetails(@RequestParam (name="division")String division,@RequestParam (name = "date")String date) {
        List<Object> resultSet = disqueDetailsRepository.findDisqueDetails(division,date);
        if(resultSet == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(resultSet);
    }
}
