package com.anbiko.anbiko.Entity;
import com.anbiko.anbiko.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class UserDetail {
    @Id
    private Long userDetailsId;
    @Column(length = 40)
    private String nom;
    @Column(length = 40)
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    /*private LocalDate dob;*/
    private LocalDate dob;
    @Column(length = 50)
    private String email;
    @Column(length = 10)
    private String telephone;
    @Column(length = 10)
    private String adresse;
    @OneToOne
    @JoinColumn(name = "userDetailsId", referencedColumnName = "userId", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    @MapsId
    private User user;
}
