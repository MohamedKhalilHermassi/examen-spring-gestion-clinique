package com.example.clinique.repositories;

import com.example.clinique.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cliniqueRepository extends JpaRepository<Clinique,Long> {
}
