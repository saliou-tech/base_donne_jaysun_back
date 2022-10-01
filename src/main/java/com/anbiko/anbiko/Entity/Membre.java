package com.anbiko.anbiko.Entity;

import com.anbiko.anbiko.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Membre {
    @Id
    @SequenceGenerator(name = "membre_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long membre_id;
    @NotBlank
    @Column(length = 40)
    private String nom;
 @NotBlank
 @Column(length = 40)
 private String prenom;
    @NotBlank
    @Column(length = 40)
    private String email;
    @Column(length = 50)
    @NotBlank
    private String adresse;
    @NotBlank
    @Column(length = 10)
    private String telephone;
    @NotBlank
    @Column(length = 10)
    private String cellule;
    @NotBlank
    @Column(length = 10)
    private String profession;
    @NotBlank
    @Column(length = 40)
    private String dateNaissance;
    @NotBlank
    @Column(length = 40)
    private String lieuNaissance;
    @NotBlank
    @Column(length = 40)
    private String numeroCarteElecteur;
    @Column(length = 40)
    private String isMarried;
    @Column(length = 40)
    private long nombreEnfant;



}
