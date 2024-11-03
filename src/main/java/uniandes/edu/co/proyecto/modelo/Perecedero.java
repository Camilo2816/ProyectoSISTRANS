package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perecederos")
public class Perecedero {
    
    @Column(name = "FECHAVENCIMIENTO")
    private Date fechaVencimiento;
    
    @Id
    @Column(name = "PRODUCTO_PRODUCTO_ID")
    private Integer producto_id;

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
