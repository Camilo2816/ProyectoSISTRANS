package uniandes.edu.co.proyecto.modelo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "CATEGORIA_ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CARACTERISTICASALMACENAMIENTO")
    private String caracteristicasAlmacenamiento;

    
    
    
    public Categoria(String nombre, String descripcion, String caracteristicasAlmacenamiento) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicasAlmacenamiento = caracteristicasAlmacenamiento;

    } 
    public Categoria()
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCaracteristicasAlmacenamiento() {
        return caracteristicasAlmacenamiento;
    }
    public void setCaracteristicasAlmacenamiento(String caracteristicasAlmacenamiento) {
        this.caracteristicasAlmacenamiento = caracteristicasAlmacenamiento;
    }
    
}
