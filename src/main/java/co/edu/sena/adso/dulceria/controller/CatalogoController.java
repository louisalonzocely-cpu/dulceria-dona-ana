package co.edu.sena.adso.dulceria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.sena.adso.dulceria.model.Categoria;
import co.edu.sena.adso.dulceria.model.Dulce;


@Controller
public class CatalogoController {

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        List<Dulce> dulces = new ArrayList<>();
        dulces.add(new Dulce(null, "Cocada blanca", "Coco rallado y azucar, receta tradicional", 3000, Categoria.COCADAS, true));
        dulces.add(new Dulce(null, "Cocada de panela", "Coco con panela, color dorado", 3000, Categoria.COCADAS, true));
        dulces.add(new Dulce(null, "Cocada de piña", "Coco con piña caramelizada", 3500, Categoria.COCADAS, true));
        dulces.add(new Dulce(null, "Alegría de millo", "Bolita de millo, coco y panela con anís", 2500, Categoria.ALEGRIAS, true));
        dulces.add(new Dulce(null, "Panelita de leche", "Leche y azúcar cortadas en cuadritos", 2000, Categoria.PANELITAS, true));
        dulces.add(new Dulce(null, "Caballito de papaya", "Papaya verde en almíbar con clavo y canela", 4500, Categoria.CONSERVAS, true));
        dulces.add(new Dulce(null, "Dulce de icaco", "Icacos en almíbar", 4000, Categoria.CONSERVAS, true));
        dulces.add(new Dulce(null, "Bolitas de tamarindo", "Pulpa de tamarindo con azúcar", 2000, Categoria.OTROS, true));

        model.addAttribute("dulces", dulces);
        return "catalogo";
    }
    

}
