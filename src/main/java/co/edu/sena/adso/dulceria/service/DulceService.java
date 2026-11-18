package co.edu.sena.adso.dulceria.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.edu.sena.adso.dulceria.model.Categoria;
import co.edu.sena.adso.dulceria.model.Dulce;
import co.edu.sena.adso.dulceria.repository.DulceRepository;

@Service
public class DulceService {

    private final DulceRepository dulceRepository;

    public DulceService(DulceRepository dulceRepository) {
        this.dulceRepository = dulceRepository;
    }

    public List<Dulce> listar() {
        return dulceRepository.findAll().stream()
                .sorted(Comparator.comparing(Dulce::getNombre))
                .toList();
    }

    public List<Dulce> listarPorCategoria(Categoria categoria) {
        if (categoria == null) {
            return listar();
        }
        return listar().stream()
                .filter(dulce -> dulce.getCategoria() == categoria)
                .toList();
                
    }

    public List<Dulce> destacados() {
        return listar().stream()
                .filter(Dulce::isDisponible)
                .limit(3)
                .toList();
    }

    public Dulce buscar(Long id) {
        return dulceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dulce no encontrado" + id));
    }

}
