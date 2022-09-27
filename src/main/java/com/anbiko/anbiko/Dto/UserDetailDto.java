package com.anbiko.anbiko.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailDto {


    private Long userId;
    @Size(min = 5, max = 20)
    @NotBlank
    @Size(min = 5, max = 20)
    private String username;
    private String role;
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;
    @NotBlank
    @Pattern(regexp = "^(Homme|Femme)$", message = "le sexe  doit etre homme ou femme")
    private String sexe;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 10, max = 10, message = "Length of phone number must be 10")
    private String telephone;
    @NotNull
    @Past
    private LocalDate dob;
    @Valid
    private String adresse;
    @NotBlank
    @Size(min = 5, max = 30)
    private String nom;
    @NotBlank
    @Size(min = 5, max = 30)
    private String prenom;
}
