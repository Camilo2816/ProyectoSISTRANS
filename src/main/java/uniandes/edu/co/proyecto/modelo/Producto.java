package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public abstract class Producto {
    
    private Integer id;
    private String nombre;
    private float costoBodega;
    private float precioUnitario;
    private String presentacion;
    private Integer cantidadPresentacion;
    
    
}
