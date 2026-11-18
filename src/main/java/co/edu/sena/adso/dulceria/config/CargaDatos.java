package co.edu.sena.adso.dulceria.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.edu.sena.adso.dulceria.model.Categoria;
import co.edu.sena.adso.dulceria.model.Dulce;
import co.edu.sena.adso.dulceria.repository.DulceRepository;

@Component
public class CargaDatos implements CommandLineRunner {

    private final DulceRepository dulceRepository;

    public CargaDatos(DulceRepository dulceRepository) {
        this.dulceRepository = dulceRepository;
    }

    @Override
    public void run(String... args) {
        if (dulceRepository.count() > 0) {
            return;
        }
        Dulce tamarindo = new Dulce(null, "Bolitas de tamarindo", "Pulpa de tamarindo con azúcar", 2000, Categoria.OTROS, false);

        dulceRepository.saveAll(List.of(
                new Dulce(null, "Cocada blanca", "Coco rallado y azúcar, receta tradicional", 3000, Categoria.COCADAS, true),
                new Dulce(null, "Cocada de panela", "Coco con panela, color dorado", 3000, Categoria.COCADAS, true),
                new Dulce(null, "Cocada de piña", "Coco con piña caramelizada", 3500, Categoria.COCADAS, true),
                new Dulce(null, "Alegría de millo", "Bolita de millo, coco y panela con anís", 2500, Categoria.ALEGRIAS, true),
                new Dulce(null, "Panelita de leche", "Leche y azúcar cortadas en cuadritos", 2000, Categoria.PANELITAS, true),
                new Dulce(null, "Caballito de papaya", "Papaya verde en almíbar con clavo y canela", 4500, Categoria.CONSERVAS, true),
                new Dulce(null, "Dulce de icaco", "Icacos en almíbar", 4000, Categoria.CONSERVAS, true),
                tamarindo));
        System.out.println(">>> Se cargaron 8 dulces iniciales");
    }

}
