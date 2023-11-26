package com.example.clinique.repositories;

import com.example.clinique.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface medecinRepository extends JpaRepository<Medecin,Long> {
}
