package com.example.clinique.controllers;

import com.example.clinique.entities.Patient;
import com.example.clinique.entities.Poste;
import com.example.clinique.services.patientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("patient")
public class patientController {
    patientService PatientService;
    @PostMapping("add-affect-patient/{idMedecin}")
    public Long addPatientAffectMedecin(@RequestBody Patient patient,@PathVariable Long idMedecin)
    {
        return PatientService.ajouterPatientEtAffecterAuMedecin(patient,idMedecin);
    }


}
