package ma.enset.gestionpatient.security.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data   // Generates getters, setters, toString, equals, and hashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppRole {
    @Id
    private String role;
}
