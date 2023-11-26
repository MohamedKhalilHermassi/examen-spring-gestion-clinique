package com.example.clinique.services;

import com.example.clinique.entities.Medecin;
import com.example.clinique.entities.Patient;
import com.example.clinique.repositories.medecinRepository;
import com.example.clinique.repositories.patientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class patientService implements IPatientService{
    patientRepository PatientRepository;
    medecinRepository MedecinRepository;
   public Long ajouterPatientEtAffecterAuMedecin(Patient patient, Long idMedecin)
   {

       Medecin medecin = MedecinRepository.findById(idMedecin).get();
       List<Medecin> medecins =  patient.getMedecins();
       medecins.add(medecin);
       patient.setMedecins(medecins);

       List<Patient> patients = medecin.getPatients();
       patients.add(patient);
       medecin.setPatients(patients);
       PatientRepository.save(patient);
       MedecinRepository.save(medecin);

       return patient.getId();
   }
}
