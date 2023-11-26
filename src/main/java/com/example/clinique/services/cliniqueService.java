package com.example.clinique.services;

import com.example.clinique.entities.Clinique;
import com.example.clinique.repositories.cliniqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class cliniqueService implements ICliniqueService{
    cliniqueRepository cliniqueRepository;
    @Override
    public Long ajouterClinique(Clinique clinique) {
         cliniqueRepository.save(clinique);
         return clinique.getId();
    }

}
