package ma.enset.gestionpatient.repository;

import ma.enset.gestionpatient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Méthode pour rechercher des patients par nom
    List<Patient> findByNomContains(String nom);
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.renderVous WHERE p.id = :id")
    Patient findPatientWithRendezVous(@Param("id") Long id);


}
