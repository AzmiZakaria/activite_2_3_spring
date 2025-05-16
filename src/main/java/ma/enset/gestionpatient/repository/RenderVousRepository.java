package ma.enset.gestionpatient.repository;

import ma.enset.gestionpatient.entities.Medecin;
import ma.enset.gestionpatient.entities.RenderVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenderVousRepository extends JpaRepository<RenderVous, Long> {

}
