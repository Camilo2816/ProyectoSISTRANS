package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodega")
public class Bodega {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "BODEGA_ID")
    private Integer id;
    private String nombre;

    @Column(name = "TAMAÑO")
    private Float tamanio;
    private Integer capacidad;

    @ManyToOne
    private Sucursal sucursal;

    public Bodega(String nombre, Float tamanio, Integer capacidad) {

        this.nombre = nombre;
        this.tamanio = tamanio;
        this.capacidad = capacidad;
    }
    public Bodega() 
    {;}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Float getTamanio() {
        return tamanio;
    }
    public void setTamanio(Float tamanio) {
        this.tamanio = tamanio;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
