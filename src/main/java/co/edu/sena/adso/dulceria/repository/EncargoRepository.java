package co.edu.sena.adso.dulceria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.adso.dulceria.model.Encargo;

public interface EncargoRepository extends JpaRepository<Encargo, Long> {
    List<Encargo> findAllByOrderByCreadoEnDesc();
}
