package co.edu.sena.adso.dulceria.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import co.edu.sena.adso.dulceria.model.Categoria;
import co.edu.sena.adso.dulceria.model.Dulce;

@Repository
public class DulceRepositoryMemoria implements DulceRepository {

    private final Map<Long, Dulce> datos = new ConcurrentHashMap<>();
    private final AtomicLong secuencia = new AtomicLong();

    public DulceRepositoryMemoria() {
        save(new Dulce(null, "Cocada blanca", "Coco rallado y azucar, receta tradicional", 3000, Categoria.COCADAS, true));
        save(new Dulce(null, "Cocada de panela", "Coco con panela, color dorado", 3000, Categoria.COCADAS, true));
        save(new Dulce(null, "Cocada de piña", "Coco con piña caramelizada", 3500, Categoria.COCADAS, true));
        save(new Dulce(null, "Alegría de millo", "Bolita de millo, coco y panela con anís", 2500, Categoria.ALEGRIAS, true));
        save(new Dulce(null, "Panelita de leche", "Leche y azúcar cortadas en cuadritos", 2000, Categoria.PANELITAS, true));
        save(new Dulce(null, "Caballito de papaya", "Papaya verde en almíbar con clavo y canela", 4500, Categoria.CONSERVAS, true));
        save(new Dulce(null, "Dulce de icaco", "Icacos en almíbar", 4000, Categoria.CONSERVAS, true));
        save(new Dulce(null, "Bolitas de tamarindo", "Pulpa de tamarindo con azúcar", 2000, Categoria.OTROS, false));
    }

    @Override
    public List<Dulce> findAll() {
        return new ArrayList<>(datos.values());
    }

    @Override
    public Optional<Dulce> findById(Long id) {
        return Optional.ofNullable(datos.get(id));
    }

    @Override
    public Dulce save(Dulce dulce) {
        if (dulce.getId() == null) {
            dulce.setId(secuencia.incrementAndGet());
        } else {
            secuencia.updateAndGet(actual -> Math.max(actual, dulce.getId()));
        }
        datos.put(dulce.getId(), dulce);
        return dulce;
    }

    @Override
    public void deleteById(Long id) {
        datos.remove(id);
    }
}
