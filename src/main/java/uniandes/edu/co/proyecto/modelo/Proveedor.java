package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROVEEDOR_ID")
    private Integer id;

    @Column(name = "NIT")
    private String nit;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "PERSONACONTACTO")
    private String personaContacto;

    @Column(name = "TELEFONO")
    private String telefono;

   // Constructores

    public Proveedor(String nit, String nombre, String direccion, String personaContacto, String telefono)
    {
        this.nit= nit;
        this.nombre=nombre;
        this.direccion=direccion;
        this.personaContacto=personaContacto;
        this.telefono=telefono;
    }


    public Proveedor()
    {;}

    // Getters y Setters
    public Integer getId() {
        return id;
    }


    public String getNit() {
        return nit;
    }


    public String getNombre() {
        return nombre;
    }


    public String getDireccion() {
        return direccion;
    }


    public String getPersonaContacto() {
        return personaContacto;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public void setNit(String nit) {
        this.nit = nit;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

}
