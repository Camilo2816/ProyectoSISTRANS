package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "perecedero")
public class Perecedero extends Producto{
    
    @Column(name = "FECHAVENCIMIENTO")
    private Date fechaVencimiento;
   // Constructores

    public Perecedero(Date fechaVencimiento)
    {
    this.fechaVencimiento=fechaVencimiento;
    }

    
    public Perecedero()
    {;}
    // Getters y Setters

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }


    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


    
}
