package co.edu.sena.adso.dulceria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.sena.adso.dulceria.model.Categoria;
import co.edu.sena.adso.dulceria.service.DulceService;

@Controller
@RequestMapping ("/catalogo")
public class CatalogoController {

    private final DulceService dulceService;

    public CatalogoController(DulceService dulceService) {
        this.dulceService = dulceService;
    }

    @GetMapping
    public String catalogo(@RequestParam (name = "categoria", required = false) Categoria categoria, Model model) {
        model.addAttribute("dulces", dulceService.listarPorCategoria(categoria));
        model.addAttribute("categorias", Categoria.values());
        model.addAttribute("categoriaActual", categoria);
        return "catalogo";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dulce", dulceService.buscar(id));
        return "detalle";
    }
    

}
