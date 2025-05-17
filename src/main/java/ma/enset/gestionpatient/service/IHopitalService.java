package ma.enset.gestionpatient.service;

import java.util.List;

import javax.swing.Painter;

import ma.enset.gestionpatient.entities.Consultation;
import ma.enset.gestionpatient.entities.Medecin;
import ma.enset.gestionpatient.entities.Patient;
import ma.enset.gestionpatient.entities.RenderVous;

public interface IHopitalService {
    Patient savePatient(Patient patient);
    Patient findByIDPatient(Long id);
    List<Patient> findAllPatients();

    Medecin saveMedecin(Medecin medecin);
    Medecin findByIDMedecin(Long id);
    List<Medecin> findAllMedecins();

    RenderVous saveRDV(RenderVous renderVous);
    RenderVous findByIDRDV(Long id);
    List<RenderVous> findAllRDV();

    Consultation saveConsultation(Consultation consultation);
    Consultation findByIDConsultation(Long id);
    List<Consultation> findAllConsultations();
}
