package ma.enset.gestionpatient.web;

import lombok.AllArgsConstructor;
import ma.enset.gestionpatient.entities.Patient;
import ma.enset.gestionpatient.repository.PatientRepository;
import ma.enset.gestionpatient.service.IHopitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private final IHopitalService hopitalService;


    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "4") int size,
                        @RequestParam(defaultValue = "") String search) {

        Page<Patient> patientPage = hopitalService.searchPatientByKeywords(page, size, search);
        model.addAttribute("ListPatients", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("search",search);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String search, int page) {
        hopitalService.deletePatient(id);
        return "redirect:/index?page="+page+"&search="+search;
    }


}
