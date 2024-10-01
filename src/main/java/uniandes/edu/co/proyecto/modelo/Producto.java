package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTO_ID")
    private Integer productoid;
    private String nombre;
    private float costoBodega;
    private float precioUnitario;
    private String presentacion;
    private Integer cantidadPresentacion;
    private String unidadMedida;
    private Integer codigoBarras;
    private Date fechaExpiracion;

    
    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID") 
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ESPECIFICACIONEMPAQUETADO_ID") 
    private EspecificacionEmpaquetado especificacionEmpaquetado_id;
       // Constructores

    public Producto(String nombre, float costoBodega, float precioUnitario, String presentacion, Integer cantidadPresentacion, String unidadMedida, Integer codigoBarras, Date fechaExpiracion, Categoria categoria, EspecificacionEmpaquetado especificacionEmpaquetado_id)
    {
    this.nombre=nombre;
    this.costoBodega=costoBodega;
    this.precioUnitario=precioUnitario;
    this.presentacion=presentacion;
    this.cantidadPresentacion=cantidadPresentacion;
    this.unidadMedida=unidadMedida;
    this.codigoBarras=codigoBarras;
    this.fechaExpiracion=fechaExpiracion;
    this.especificacionEmpaquetado_id = especificacionEmpaquetado_id;
    this.categoria = categoria;
    }

    

    public Producto()
    {;}


    // Getters y Setters
    public Integer getId() {
        return productoid;
    }



    public String getNombre() {
        return nombre;
    }



    public float getCostoBodega() {
        return costoBodega;
    }



    public float getPrecioUnitario() {
        return precioUnitario;
    }



    public String getPresentacion() {
        return presentacion;
    }



    public Integer getCantidadPresentacion() {
        return cantidadPresentacion;
    }



    public String getUnidadMedida() {
        return unidadMedida;
    }



    public Integer getCodigoBarras() {
        return codigoBarras;
    }



    public Date getFechaVencimiento() {
        return fechaExpiracion;
    }

    

    public Categoria getCategoria_id() {
        return categoria;
    }



    public EspecificacionEmpaquetado getEspecificacionEmpaquetado_id() {
        return especificacionEmpaquetado_id;
    }



    public void setId(Integer productoid) {
        this.productoid = productoid;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public void setCostoBodega(float costoBodega) {
        this.costoBodega = costoBodega;
    }



    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }



    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }



    public void setCantidadPresentacion(Integer cantidadPresentacion) {
        this.cantidadPresentacion = cantidadPresentacion;
    }



    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }



    public void setCodigoBarras(Integer codigoBarras) {
        this.codigoBarras = codigoBarras;
    }



    public void setFechaVencimiento(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }



    public void setCategoria_id(Categoria categoria) {
        this.categoria = categoria;
    }



    public void setEspecificacionEmpaquetado_id(EspecificacionEmpaquetado especificacionEmpaquetado_id) {
        this.especificacionEmpaquetado_id = especificacionEmpaquetado_id;
    }

    
}
