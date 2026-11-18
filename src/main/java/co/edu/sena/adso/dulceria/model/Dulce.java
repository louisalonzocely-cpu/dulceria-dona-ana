package co.edu.sena.adso.dulceria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Dulce {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Categoria categoria;
    private boolean disponible = true;    
}
