package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private float tamaño;
    private String telefono;
    private String direccion;

    
    public Sucursal(String nombre, float tamaño, String telefono, String direccion)
    {
    this.nombre=nombre;
    this.tamaño=tamaño;
    this.telefono=telefono;
    this.direccion=direccion;
    }
    
    public Sucursal()
    {;}

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getTamaño() {
        return tamaño;
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

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    


}
