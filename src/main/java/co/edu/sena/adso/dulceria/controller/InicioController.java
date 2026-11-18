package co.edu.sena.adso.dulceria.controller;

import java.time.LocalTime;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class InicioController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("nombreTienda", "Dulces Doña Ana");
        model.addAttribute("eslogan", "Dulces tipicos del Portal de los Dulces - Cartagena de Indias");
        model.addAttribute("horario", "Todos los dias de 9:00 a.m. a 9:00 p.m.");

        int hora = LocalTime.now().getHour();
        String saludo = hora < 12 ? "Buenos días" : (hora < 18 ? "Buenas tardes" : "Buenas noches");

        model.addAttribute("saludo", saludo);

        return "inicio";
    }

}
