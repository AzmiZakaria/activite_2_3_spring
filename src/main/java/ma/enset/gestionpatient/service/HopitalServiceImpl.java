package ma.enset.gestionpatient.service;

import ma.enset.gestionpatient.entities.Consultation;
import ma.enset.gestionpatient.entities.Medecin;
import ma.enset.gestionpatient.entities.Patient;
import ma.enset.gestionpatient.entities.RenderVous;
import ma.enset.gestionpatient.repository.ConsultationRepository;
import ma.enset.gestionpatient.repository.MedecinRepository;
import ma.enset.gestionpatient.repository.PatientRepository;
import ma.enset.gestionpatient.repository.RenderVousRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class HopitalServiceImpl implements IHopitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RenderVousRepository renderVousRepository;

    public HopitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RenderVousRepository renderVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.renderVousRepository = renderVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RenderVous saveRDV(RenderVous renderVous) {
        return renderVousRepository.save(renderVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findByIDPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> findPatientsByPage(int page, int size) {
        return patientRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Patient> searchPatientByKeywords(int page, int size, String search) {
        return patientRepository.findByNomContains(search, PageRequest.of(page, size));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Medecin findByIDMedecin(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medecin> findAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public RenderVous findByIDRDV(Long id) {
        return renderVousRepository.findById(id).orElse(null);
    }

    @Override
    public List<RenderVous> findAllRDV() {
        return renderVousRepository.findAll();
    }

    @Override
    public Consultation findByIDConsultation(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Consultation> findAllConsultations() {
        return consultationRepository.findAll();
    }

}
