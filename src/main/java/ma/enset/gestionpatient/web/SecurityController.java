package ma.enset.gestionpatient.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.gestionpatient.entities.Patient;
import ma.enset.gestionpatient.service.IHopitalService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class SecurityController {
    @GetMapping("/notAuthenticated")
    public String notAuthenticated() {
        return "notAuthenticated";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
