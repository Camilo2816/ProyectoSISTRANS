package uniandes.edu.co.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "CIUDAD_ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "ciudad") 
    private List<Sucursal> sucursales = new ArrayList<>();
   // Constructores

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad() {}

    // Getters y Setters
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
}
