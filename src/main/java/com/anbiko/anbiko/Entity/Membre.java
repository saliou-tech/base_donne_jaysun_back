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

    private String nom;
 @NotBlank
 private String prenom;
    @NotBlank
    private String email;
    @NotBlank
    private String adresse;
    @NotBlank
    private String telephone;
    @NotBlank
    private String cellule;
    @NotBlank
    private String profession;
    @NotBlank
    private String dateNaissance;
    @NotBlank
    private String lieuNaissance;
    @NotBlank
    private String numeroCarteElecteur;
    private String isMarried;
    private long nombreEnfant;



}
