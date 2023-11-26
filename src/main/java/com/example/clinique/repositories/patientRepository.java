package com.example.clinique.repositories;

import com.example.clinique.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface patientRepository extends JpaRepository<Patient,Long> {
}
