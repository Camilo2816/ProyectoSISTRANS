package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private float costoBodega;
    private float precioUnitario;
    private String presentacion;
    private Integer cantidadPresentacion;
    private String unidadMedida;
    private Integer codigoBarras;
    private Date fechaVencimiento;
    
    public Producto(String nombre, float costoBodega, float precioUnitario, String presentacion, Integer cantidadPresentacion, String unidadMedida, Integer codigoBarras, Date fechaVencimiento)
    {
    this.nombre=nombre;
    this.costoBodega=costoBodega;
    this.precioUnitario=precioUnitario;
    this.presentacion=presentacion;
    this.cantidadPresentacion=cantidadPresentacion;
    this.unidadMedida=unidadMedida;
    this.codigoBarras=codigoBarras;
    this.fechaVencimiento=fechaVencimiento;
    }

    

    public Producto()
    {;}



    public Integer getId() {
        return id;
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
        return fechaVencimiento;
    }



    public void setId(Integer id) {
        this.id = id;
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



    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    
}
