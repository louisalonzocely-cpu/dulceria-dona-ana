package co.edu.sena.adso.dulceria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.sena.adso.dulceria.model.Categoria;
import co.edu.sena.adso.dulceria.model.Dulce;
import co.edu.sena.adso.dulceria.service.DulceService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/api/dulces")
public class DulcesApiController {
    private final DulceService dulceService;

    public DulcesApiController(DulceService dulceService) {
        this.dulceService = dulceService;
    }

    @GetMapping
    public List<Dulce> listar(@RequestParam(name = "categoria", required = false) Categoria categoria) {
        return dulceService.listarPorCategoria(categoria);
    }

    @GetMapping("/{id}")    
    public Dulce buscar(@PathVariable("id") Long id) {
        return dulceService.buscar(id);
    }

}
