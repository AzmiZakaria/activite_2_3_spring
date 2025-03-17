package ma.enset.gestion_pation.repository;

import ma.enset.gestion_pation.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
