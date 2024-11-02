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
@Table(name = "ordencompra")
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDENCOMPRA_ID")
    private Integer id;

    @Column(name = "PRECIO")
    private Float precio;

    @Column(name = "FECHAENTREGA")
    private Date fechaEntrega;

    @Column(name = "ESTADO")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "PROVEEDOR_PROVEEDOR_ID")
    private Proveedor proveedor;


    @ManyToOne
    @JoinColumn(name = "SUCURSAL_SUCURSAL_ID")
    private Sucursal sucursal;
   // Constructores

    public OrdenCompra( Float precio, Date fechaEntrega, String estado) {

        
        this.precio = precio;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }
    public OrdenCompra() 
    {;}
    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
  
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public Date getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

}
