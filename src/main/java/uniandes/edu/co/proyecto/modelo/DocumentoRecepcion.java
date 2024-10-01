package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "documento recepción")
public class DocumentoRecepcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date fechaEntregado;
   // Constructores

    public DocumentoRecepcion(Date fechaEntregado) {

        this.fechaEntregado = fechaEntregado;
    }
    public DocumentoRecepcion() 
    {;}


        // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFechaEntregado() {
        return fechaEntregado;
    }
    public void setFechaEntregado(Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }
}
