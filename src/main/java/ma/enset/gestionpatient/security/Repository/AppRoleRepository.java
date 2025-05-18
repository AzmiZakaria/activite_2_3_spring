package ma.enset.gestionpatient.security.Repository;

import ma.enset.gestionpatient.security.entities.AppRole;
import ma.enset.gestionpatient.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
    AppRole findByUsername(String username);

}
