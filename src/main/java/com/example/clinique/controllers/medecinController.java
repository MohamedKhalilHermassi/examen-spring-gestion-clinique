package com.example.clinique.controllers;

import com.example.clinique.entities.Medecin;
import com.example.clinique.entities.Poste;
import com.example.clinique.services.medecinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("medecin")
public class medecinController {
    medecinService MedecinService;
    @PostMapping("add-medecin")
    public Long addMedecin(@RequestBody Medecin medecin){
        return  MedecinService.ajouterMedecin(medecin);

    }

    @PutMapping("affecter-medecin-actionnaire-clinique/{medecinId}/{cliniqueId}")
    public void affecterMedecinActionnaireAClinique(@PathVariable Long medecinId,@PathVariable Long cliniqueId)
    {
         MedecinService.affecterMedecinActionnaireAClinique(medecinId,cliniqueId);
    }

    @PutMapping("affecter-medecin-ordinaire-clinique/{medecinId}/{cliniqueId}")
    public void affecterMedecinOrdinaireAClinique(@PathVariable Long medecinId,@PathVariable Long cliniqueId)
    {

        MedecinService.affecterMedecinOrdinaireAClinique(medecinId,cliniqueId);
    }
    @GetMapping("cardiologues-nom")
    public List<String> getCardiologues()
    {
       return MedecinService.getCardiologueMedecinNames();
    }
    @GetMapping("get-nombre-actionnaire/{poste}")
    public Long getnombreActionnaire(@PathVariable Poste poste)
    {
        return MedecinService.getNombrePatientsExaminesParMedecinPoste(poste);
    }
}
