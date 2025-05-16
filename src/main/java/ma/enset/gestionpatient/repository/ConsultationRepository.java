package ma.enset.gestionpatient.repository;

import ma.enset.gestionpatient.entities.Consultation;
import ma.enset.gestionpatient.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
