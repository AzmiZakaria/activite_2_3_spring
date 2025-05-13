package ma.enset.gestionpatient.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateConsultation;
    private String rapport;
    @OneToOne(mappedBy = "consultation")
    private RenderVous renderVous;
}
