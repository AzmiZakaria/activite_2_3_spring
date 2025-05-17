package ma.enset.gestionpatient.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RenderVous renderVous;
}
