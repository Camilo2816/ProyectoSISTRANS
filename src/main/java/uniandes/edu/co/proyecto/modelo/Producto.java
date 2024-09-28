package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private float costoBodega;
    private float precioUnitario;
    private String presentacion;
    private Integer cantidadPresentacion;
    private String unidadMedida;
    private Integer codigoBarras;
    private Date fechaVencimiento;
    
    
}
