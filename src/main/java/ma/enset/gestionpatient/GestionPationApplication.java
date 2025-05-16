package ma.enset.gestionpatient;

import ma.enset.gestionpatient.entities.Patient;
import ma.enset.gestionpatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionPationApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

       public static void main(String[] args) {
        SpringApplication.run(GestionPationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("zakaria", "achraf", "mourad").forEach(
                nom -> {
                    Patient patient = new Patient();
                    patient.setNom(nom);
                    patient.setDateNaissance(new Date());
                    patient.setScore((int)(Math.random() * 100) + 1);
                    patient.setMalade(patient.getScore() > 50);
                    patientRepository.save(patient);
                }
        );

//        System.out.println("=== Consulter tous les patients ===");
//        patientRepository.findAll().forEach(p -> {
//            System.out.println(p.getNom() + " | Score: " + p.getScore());
//        });
//        System.out.println("=== Consulter un patient ===");
//        Patient p = patientRepository.findById(1L).orElse(null);
//        if (p != null) {
//            System.out.println("Patient avec id"+p.getId()+": " + p.getNom());
//        }
//        System.out.println("=== Chercher des patients avec nom contenant 'a' ===");
//        patientRepository.findByNomContains("a").forEach(pat -> {
//            System.out.println(pat.getNom());
//        });
//        System.out.println("=== Mettre à jour un patient  ===");
//        Patient patientToUpdate = patientRepository.findById(2L).orElse(null);
//        if (patientToUpdate != null) {
//            System.out.println("Patient avant mis a jour: " + patientToUpdate.getNom()+ " | score: " + patientToUpdate.getScore());
//            patientToUpdate.setScore(5);
//            patientRepository.save(patientToUpdate);
//            System.out.println("Patient mis à jour: " + patientToUpdate.getNom() + " | Nouveau score: " + patientToUpdate.getScore());
//        }
//        System.out.println("=== supprimer un patientt ===");
//        patientRepository.deleteById(3L);
//        System.out.println("Patient avec ID 3 supprimé.");
//        System.out.println("Consulter tous les patients");
//        patientRepository.findAll().forEach(pat -> {
//            System.out.println(pat.getNom() + " | Score: " + pat.getScore());
//        });
       }
}
