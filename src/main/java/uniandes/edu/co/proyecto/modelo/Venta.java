package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VENTA_ID")
    private Integer id;
    private Date fecha;
       // Constructores

    public Venta(Date fecha)
    {
    this.fecha= fecha;
    }

    public Venta()
    {;}
    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
