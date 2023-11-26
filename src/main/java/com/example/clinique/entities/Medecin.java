package com.example.clinique.entities;

import com.example.clinique.CliniqueApplication;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate DateEmbauche;
    private String email;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @Enumerated(EnumType.STRING)
    private Poste poste;
    @ManyToMany( mappedBy = "medecins",cascade = CascadeType.ALL)
    private List<Patient> patients;
    @ManyToOne
    private Clinique clinique;
    @OneToOne
    private Clinique cliniqueA;

}
