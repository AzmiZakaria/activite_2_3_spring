package ma.enset.gestionpatient.web;

import lombok.AllArgsConstructor;
import ma.enset.gestionpatient.entities.Patient;
import ma.enset.gestionpatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private final PatientRepository patientRepository;
//    @Autowired
//    public PatientController(PatientRepository patientRepository){
//        this.patientRepository = patientRepository;
//    }
    @GetMapping("/index")
    public String index(Model model) {
        List<Patient> patientList=patientRepository.findAll();
        model.addAttribute("ListPatients",patientList);
        return "patients";
    }

}
