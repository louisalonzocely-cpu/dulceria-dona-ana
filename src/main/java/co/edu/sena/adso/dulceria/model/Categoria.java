package co.edu.sena.adso.dulceria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor 
public enum Categoria {

    COCADAS("Cocadas"),
    ALEGRIAS("Alegrías"),
    PANELITAS("Panelitas"),
    CONSERVAS("Conservas"),
    OTROS("Otros dulces");

    private final String nombre;

}
