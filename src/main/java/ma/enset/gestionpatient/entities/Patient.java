package ma.enset.gestionpatient.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data   // Generates getters, setters, toString, equals, and hashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Collection<RenderVous> renderVous=new ArrayList<>();
}
