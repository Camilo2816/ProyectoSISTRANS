package uniandes.edu.co.proyecto.modelo;
//Hpla
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodega")
public class Bodega {
    
        // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BODEGA_ID")
    private Integer id;
    private String nombre;

    @Column(name = "TAMAÑO")
    private Double tamanio;
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "SUCURSAL_SUCURSAL_ID")
    private Sucursal sucursal;

    // Constructores
    public Bodega(String nombre, Double tamanio, Integer capacidad) {

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
    public Double getTamanio() {
        return tamanio;
    }
    public void setTamanio(Double tamanio) {
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
