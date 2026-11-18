package co.edu.sena.adso.dulceria.repository;

import java.util.List;
import java.util.Optional;

import co.edu.sena.adso.dulceria.model.Dulce;

public interface DulceRepository {
    List<Dulce> findAll();
    Optional<Dulce> findById(Long id);
    Dulce save(Dulce dulce);
    void deleteById(Long id);
}
