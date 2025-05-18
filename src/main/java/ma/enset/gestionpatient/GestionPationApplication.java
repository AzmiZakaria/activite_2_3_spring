package ma.enset.gestionpatient;

import ma.enset.gestionpatient.entities.Consultation;
import ma.enset.gestionpatient.entities.Medecin;
import ma.enset.gestionpatient.entities.Patient;
import ma.enset.gestionpatient.entities.RenderVous;
import ma.enset.gestionpatient.entities.StatusRDV;
import ma.enset.gestionpatient.repository.ConsultationRepository;
import ma.enset.gestionpatient.repository.MedecinRepository;
import ma.enset.gestionpatient.repository.PatientRepository;
import ma.enset.gestionpatient.repository.RenderVousRepository;
import ma.enset.gestionpatient.security.service.IAccountService;
import ma.enset.gestionpatient.service.IHopitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionPationApplication{

   public static void main(String[] args) {
    SpringApplication.run(GestionPationApplication.class, args);
   }
   @Bean
   PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }
//    @Bean
   CommandLineRunner commandLineRunnerUserDetails(IAccountService accountService){
       return args -> {
        try {
           accountService.addNewRole("USER");
           accountService.addNewRole("ADMIN");
           accountService.addNewUser("user1","1234","user1@gmail.com","1234");
           accountService.addNewUser("user2","1234","user2@gmail.com","1234");
           accountService.addNewUser("admin","1234","admin@gmail.com","1234");

           accountService.addRoleToUser("user1","USER");
           accountService.addRoleToUser("user2","USER");
           accountService.addRoleToUser("admin","USER");
           accountService.addRoleToUser("admin","ADMIN");

      
        } catch (Exception e) {
           e.printStackTrace();}

       };
   }
//   @Bean
   CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
       PasswordEncoder passwordEncoder= passwordEncoder();
       return args -> {
           UserDetails u1=jdbcUserDetailsManager.loadUserByUsername("user1");
           if(u1==null){
               jdbcUserDetailsManager.createUser(
                       User.withUsername("user1")
                               .password(passwordEncoder.encode("1234"))
                               .roles("USER").build()
               );
           }
           UserDetails u2=jdbcUserDetailsManager.loadUserByUsername("user2");
           if(u2==null){
               jdbcUserDetailsManager.createUser(
                       User.withUsername("user2")
                               .password(passwordEncoder.encode("1234"))
                               .roles("USER").build()
               );
           }
           UserDetails u3=jdbcUserDetailsManager.loadUserByUsername("admin");
           if(u3==null){
               jdbcUserDetailsManager.createUser(
                       User.withUsername("admin")
                               .password(passwordEncoder.encode("1234"))
                               .roles("USE  R","ADMIN").build()
               );
           }
//           jdbcUserDetailsManager.cr
        };
   }

//    @Bean
    CommandLineRunner start(IHopitalService hopitalService) {
           return args -> {
               Stream.of("zakaria", "achraf", "mourad", "imad", "asmaa", "rachid", "youssef", "fatima", "salma", "hamza", "sara", "ayoub", "nour", "khalid", "imane").forEach(
                       nom -> {
                           Patient patient = new Patient();
                           patient.setNom(nom);
                           patient.setDateNaissance(new Date());
                           patient.setScore((int)(Math.random() * 100) + 1);
                           patient.setMalade(patient.getScore() > 50);
                           hopitalService.savePatient(patient);
                       }
               );

               Stream.of("ahmed", "simo", "yassine").forEach(
                       nom -> {
                           Medecin medecin = new Medecin();
                           medecin.setNom(nom);
                           medecin.setEmail(nom + "@gmail.com");
                           medecin.setSpecialité(Math.random() > 0.5 ? "Cardiologue" : "Dentiste");
                           hopitalService.saveMedecin(medecin);
                       }
               );

               RenderVous renderVous = new RenderVous();
               renderVous.setDate(new Date());
               renderVous.setAnnule(false);
               renderVous.setStatus(StatusRDV.PENDING);
                renderVous.setPatient(hopitalService.findByIDPatient(1L));
                renderVous.setMedecin(hopitalService.findByIDMedecin(1L));
               hopitalService.saveRDV(renderVous);

               Consultation consultation = new Consultation();
               consultation.setDateConsultation(new Date());
               consultation.setRapport("Tout va bien");
               consultation.setRenderVous(renderVous);
                hopitalService.saveConsultation(consultation);
               // Affichage des Patients
               System.out.println("=== Liste des Patients ===");
                hopitalService.findAllPatients().forEach(p -> {
                     System.out.println("ID: " + p.getId() + ", Nom: " + p.getNom() + ", Date de Naissance: " + p.getDateNaissance() +
                            ", Score: " + p.getScore() + ", Malade: " + p.isMalade());
                });

               // Affichage des Médecins
               System.out.println("=== Liste des Médecins ===");
                hopitalService.findAllMedecins().forEach(m -> {
                     System.out.println("ID: " + m.getId() + ", Nom: " + m.getNom() + ", Email: " + m.getEmail() +
                            ", Spécialité: " + m.getSpecialité());
                });

               // Affichage des RendezVous
               System.out.println("=== Liste des RendezVous ===");
               hopitalService.findAllRDV().forEach(rdv -> {
                   System.out.println("ID: " + rdv.getId() + ", Date: " + rdv.getDate() + ", Annulé: " + rdv.isAnnule() +
                           ", Status: " + rdv.getStatus() + ", Patient ID: " + (rdv.getPatient() != null ? rdv.getPatient().getId() : "null") +
                           ", Médecin ID: " + (rdv.getMedecin() != null ? rdv.getMedecin().getId() : "null"));
               });

               // Affichage des Consultations
               System.out.println("=== Liste des Consultations ===");
                hopitalService.findAllConsultations().forEach(c -> {
                     System.out.println("ID: " + c.getId() + ", Date: " + c.getDateConsultation() + ", Rapport: " + c.getRapport() +
                            ", RendezVous ID: " + (c.getRenderVous() != null ? c.getRenderVous().getId() : "null"));
                });

               // Affichage des RendezVous d'un Patient
               System.out.println("=== RendezVous du Patient avec ID 1 ===");
                Patient patient = hopitalService.findByIDPatient(1L);
               if (patient != null) {
                   System.out.println("Patient: " + patient.getNom());
                   Collection<RenderVous> rendezVous = patient.getRenderVous();
                   System.out.println("RendezVous:"+ rendezVous.size());

                   if (rendezVous != null && !rendezVous.isEmpty()) {
                       rendezVous.forEach(rdv -> {
                           System.out.println("RendezVous ID: " + rdv.getId() +
                                   ", Date: " + rdv.getDate() +
                                   ", Status: " + rdv.getStatus());
                       });
                   } else {
                       System.out.println("Aucun rendez-vous trouvé pour ce patient");
                   }
               } else {
                   System.out.println("Patient non trouvé");
               }
           };

       }
}

