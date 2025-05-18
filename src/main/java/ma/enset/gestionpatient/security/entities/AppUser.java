package ma.enset.gestionpatient.security.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.gestionpatient.entities.RenderVous;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity @Data   // Generates getters, setters, toString, equals, and hashCode
@AllArgsConstructor @NoArgsConstructor @Builder
public class AppUser {
    @Id
    private String userId;
    @NotEmpty @Size(min = 3, max = 50) @Column(unique = true)
    private String username;
    @NotEmpty @Size(min = 3, max = 50)
    private String password;
    @NotEmpty @Email
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles;

}
