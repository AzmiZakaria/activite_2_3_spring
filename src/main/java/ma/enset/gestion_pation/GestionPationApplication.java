package ma.enset.gestion_pation;

import ma.enset.gestion_pation.entities.Patient;
import ma.enset.gestion_pation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GestionPationApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionPationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"zakaria",new Date(),false,50));
        patientRepository.save(new Patient(null,"achraf",new Date(),false,25));
        patientRepository.save(new Patient(null,"mourad",new Date(),true,100));

    }
}
