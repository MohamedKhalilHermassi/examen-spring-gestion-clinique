package com.example.clinique.controllers;

import com.example.clinique.entities.Clinique;
import com.example.clinique.services.cliniqueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

@RequestMapping("clinique")
public class clinqueController {
    cliniqueService cliniqueService;
    @PostMapping("/add-clinique")
public Long addClinique(@RequestBody Clinique clinique){
        return cliniqueService.ajouterClinique(clinique);
    }

}
