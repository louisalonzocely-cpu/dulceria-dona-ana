package co.edu.sena.adso.dulceria.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.sena.adso.dulceria.service.DulceService;


@Controller
public class InicioController {

    private final DulceService dulceService;

    public InicioController(DulceService dulceService) {
        this.dulceService = dulceService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        int hora = LocalTime.now().getHour();
        String saludo = hora < 12 ? "Buenos días" : (hora < 18 ? "Buenas tardes" : "Buenas noches");

        model.addAttribute("saludo", saludo);
        model.addAttribute("horario", "Todos los dias de 9:00 a.m. a 9:00 p.m.");
        model.addAttribute("destacados", dulceService.destacados());

        return "inicio";
    }

}
