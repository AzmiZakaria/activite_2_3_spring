package ma.enset.gestionpatient.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotEmpty @Size(min = 3, max = 50)
    private String nom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;
    @DecimalMax("100") @DecimalMin("1")
    private int score;
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Collection<RenderVous> renderVous=new ArrayList<>();
}
