package com.example.clinique.services;

import com.example.clinique.entities.Medecin;
import com.example.clinique.entities.Clinique;
import com.example.clinique.entities.Patient;
import com.example.clinique.entities.Poste;
import com.example.clinique.repositories.cliniqueRepository;
import com.example.clinique.repositories.medecinRepository;
import com.example.clinique.repositories.patientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class medecinService implements IMedecinService{
    medecinRepository MedecinRepository;
    cliniqueRepository CliniqueRepository;
    patientRepository PatientRepository;
    @Override
    public Long ajouterMedecin(Medecin medecin) {
        MedecinRepository.save(medecin);


        return medecin.getId();
    }
    public Long getNombrePatientsExaminesParMedecinPoste(Poste poste)
    {
       List<Patient> patients = PatientRepository.findAll();
       List<Medecin> medecins = new ArrayList<>();
       long k=0;
    for(int i =0;i<patients.size();i++)
    {
        medecins = patients.get(i).getMedecins();
        for (int j=0;i<medecins.size();j++)
        {
            if(medecins.get(j).getPoste().equals(poste))
            {
                k++;
            }
        }


    }
    return k;
    }
    public List<String> getCardiologueMedecinNames()
    {
      List<Medecin> medecins = MedecinRepository.findAll();
      List<String> noms = new ArrayList<>();
        medecins.stream().filter(
              medecin -> medecin.getSpecialite().toString()=="CARDIOLOGUE"
      ).forEach(
              medecin -> noms.add(medecin.getNom())
        );
      return noms;

    }
    public void affecterMedecinActionnaireAClinique(Long medecinId, Long cliniqueId)
    {

            Clinique clinique = CliniqueRepository.findById(cliniqueId).get();
            Medecin medecin = MedecinRepository.findById(medecinId).get();

            if ( medecin.getPoste().toString() == "ACTIONNAIRE")
            {
                medecin.setCliniqueA(clinique);
                medecin.setClinique(clinique);
                clinique.setMedecinActionnaire(medecin);
                CliniqueRepository.save(clinique);
                MedecinRepository.save(medecin);

            }

    }
    public void affecterMedecinOrdinaireAClinique(Long medecinId, Long cliniqueId)
    {
        Clinique clinique = CliniqueRepository.findById(cliniqueId).get();
        Medecin medecin = MedecinRepository.findById(medecinId).get();
        List<Medecin> medecinsOrdinaires = clinique.getMedecinsOrdinaires();
        String poste = medecin.getPoste().toString();
        if ( poste == "ORDINAIRE")
        {
            System.out.println(clinique.toString());
            System.out.println("hello world !");
            medecin.setClinique(clinique);
            medecinsOrdinaires.add(medecin);
            clinique.setMedecinsOrdinaires(medecinsOrdinaires);
            CliniqueRepository.save(clinique);
            MedecinRepository.save(medecin);


        }


    }

}
