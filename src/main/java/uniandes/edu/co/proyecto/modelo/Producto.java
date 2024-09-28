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
    private Float costoBodega;
    private Float precioUnitario;
    private String presentacion;
    private Integer cantidadPresentacion;
    private String unidadMedida;
    private Integer codigoBarras;
    private Date fechaVencimiento;
    private Categoria categoria_id;
    private EspecificacionEmpaquetado especificacionEmpaquetado_id;
    
    public Producto(String nombre, Float costoBodega, Float precioUnitario, String presentacion, Integer cantidadPresentacion, String unidadMedida, Integer codigoBarras, Date fechaVencimiento, Categoria categoria_id, EspecificacionEmpaquetado especificacionEmpaquetado_id)
    {
    this.nombre=nombre;
    this.costoBodega=costoBodega;
    this.precioUnitario=precioUnitario;
    this.presentacion=presentacion;
    this.cantidadPresentacion=cantidadPresentacion;
    this.unidadMedida=unidadMedida;
    this.codigoBarras=codigoBarras;
    this.fechaVencimiento=fechaVencimiento;
    this.especificacionEmpaquetado_id = especificacionEmpaquetado_id;
    this.categoria_id = categoria_id;
    }

    

    public Producto()
    {;}



    public Integer getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }



    public Float getCostoBodega() {
        return costoBodega;
    }



    public Float getPrecioUnitario() {
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

    

    public Categoria getCategoria_id() {
        return categoria_id;
    }



    public EspecificacionEmpaquetado getEspecificacionEmpaquetado_id() {
        return especificacionEmpaquetado_id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public void setCostoBodega(Float costoBodega) {
        this.costoBodega = costoBodega;
    }



    public void setPrecioUnitario(Float precioUnitario) {
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



    public void setCategoria_id(Categoria categoria_id) {
        this.categoria_id = categoria_id;
    }



    public void setEspecificacionEmpaquetado_id(EspecificacionEmpaquetado especificacionEmpaquetado_id) {
        this.especificacionEmpaquetado_id = especificacionEmpaquetado_id;
    }

    
}
