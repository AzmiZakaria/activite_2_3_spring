package ma.enset.gestionpatient.repository;

import ma.enset.gestionpatient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Méthode pour rechercher des patients par nom
    List<Patient> findByNomContains(String nom);

}
