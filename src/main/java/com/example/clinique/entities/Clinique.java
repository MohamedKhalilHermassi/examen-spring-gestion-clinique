package com.example.clinique.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String adresse;
    @OneToMany(mappedBy = "clinique", cascade = CascadeType.ALL)
    private List<Medecin> medecinsOrdinaires;
    @OneToOne
    private Medecin medecinActionnaire;

}
