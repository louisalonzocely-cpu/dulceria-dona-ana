package co.edu.sena.adso.dulceria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.sena.adso.dulceria.service.DulceService;

@Controller
public class CatalogoController {

    private final DulceService dulceService;

    public CatalogoController(DulceService dulceService) {
        this.dulceService = dulceService;
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        model.addAttribute("dulces", dulceService.listar());
        return "catalogo";
    }

}
