package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * La clase Categoria representa una entidad de la base de datos que mapea
 * la tabla "categoria". Cada instancia de esta clase corresponde a un
 * registro de dicha tabla.
 */
@Entity
@Table(name = "categoria")  // Indica que esta clase mapea a la tabla 'categoria' en la base de datos.
public class Categoria {

    // Atributos

    /**
     * Identificador único de la categoría. Es la clave primaria de la tabla.
     * Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // El valor de 'id' se genera automáticamente.
    @Column(name = "CATEGORIA_ID")  // Mapea la columna 'CATEGORIA_ID' de la tabla.
    private Integer id;

    /**
     * Nombre de la categoría. Representa el campo 'NOMBRE' en la tabla.
     */
    @Column(name = "NOMBRE")  // Mapea la columna 'NOMBRE' de la tabla.
    private String nombre;

    /**
     * Descripción de la categoría. Representa el campo 'DESCRIPCION' en la tabla.
     */
    @Column(name = "DESCRIPCION")  // Mapea la columna 'DESCRIPCION' de la tabla.
    private String descripcion;

    /**
     * Características de almacenamiento de la categoría, como temperatura, humedad, etc.
     * Representa el campo 'CARACTERISTICASALMACENAMIENTO' en la tabla.
     */
    @Column(name = "CARACTERISTICASALMACENAMIENTO")  // Mapea la columna 'CARACTERISTICASALMACENAMIENTO' de la tabla.
    private String caracteristicasAlmacenamiento;

    // Constructores

    /**
     * Constructor que permite crear una categoría proporcionando su nombre,
     * descripción y características de almacenamiento.
     *
     * @param nombre Nombre de la categoría.
     * @param descripcion Descripción de la categoría.
     * @param caracteristicasAlmacenamiento Características de almacenamiento de la categoría.
     */
    public Categoria(String nombre, String descripcion, String caracteristicasAlmacenamiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caracteristicasAlmacenamiento = caracteristicasAlmacenamiento;
    }

    /**
     * Constructor vacío necesario para JPA.
     */
    public Categoria() { 
        // Constructor por defecto necesario para que JPA pueda instanciar la clase.
    }

    // Getters y Setters

    /**
     * Obtiene el ID de la categoría.
     * @return El identificador único de la categoría.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID de la categoría.
     * @param id El identificador único de la categoría.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la categoría.
     * @return El nombre de la categoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     * @param nombre El nombre de la categoría.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción de la categoría.
     * @return La descripción de la categoría.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la categoría.
     * @param descripcion La descripción de la categoría.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene las características de almacenamiento de la categoría.
     * @return Las características de almacenamiento de la categoría.
     */
    public String getCaracteristicasAlmacenamiento() {
        return caracteristicasAlmacenamiento;
    }

    /**
     * Establece las características de almacenamiento de la categoría.
     * @param caracteristicasAlmacenamiento Las características de almacenamiento de la categoría.
     */
    public void setCaracteristicasAlmacenamiento(String caracteristicasAlmacenamiento) {
        this.caracteristicasAlmacenamiento = caracteristicasAlmacenamiento;
    }
}

