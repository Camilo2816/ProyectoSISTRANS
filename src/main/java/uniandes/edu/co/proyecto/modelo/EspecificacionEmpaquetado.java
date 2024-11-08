package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "especificacionempaquetado")
public class EspecificacionEmpaquetado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ESPECIFICACIONEMPAQUETADO_ID")
    private Integer id;

    @Column(name = "VOLUMEN")
    private Integer volumen;

    @Column(name = "PESO")
    private Integer peso;
   // Constructores

    public EspecificacionEmpaquetado(Integer volumen, Integer peso) {

        this.volumen = volumen;
        this.peso = peso;
    }
    public EspecificacionEmpaquetado() 
    {;}
    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getVolumen() {
        return volumen;
    }
    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }
    public Integer getPeso() {
        return peso;
    }
    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
