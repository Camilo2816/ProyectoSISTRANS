package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a IDENTITY
    @Column(name = "SUCURSAL_ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "TAMAÑO")
    private Float tamanio;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "DIRECCION")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "CIUDAD_CIUDAD_ID")
    private Ciudad ciudad; // Cambiado a ciudad

    public Sucursal(String nombre, Float tamanio, String telefono, String direccion, Ciudad ciudad) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad; // Cambiado a ciudad
    }

    public Sucursal() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getTamaño() {
        return tamanio;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamaño(Float tamanio) {
        this.tamanio = tamanio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudad getCiudad() {
        return ciudad; // Cambiado a ciudad
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad; // Cambiado a ciudad
    }
}
