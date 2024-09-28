package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "perecedero")
public class Perecedero extends Producto{
    
    private Date fechaVencimiento;
}
