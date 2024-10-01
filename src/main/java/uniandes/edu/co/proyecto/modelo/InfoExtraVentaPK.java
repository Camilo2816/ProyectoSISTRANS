package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraVentaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "venta_id" , referencedColumnName = "VENTA_ID")
    private Venta venta_id;

    @ManyToOne
    @JoinColumn(name = "producto_id" , referencedColumnName = "PRODUCTO_ID")
    private Producto producto_id;
   // Constructores

    public InfoExtraVentaPK(Venta venta_id, Producto producto_id) {
        super();
        this.producto_id = producto_id;
        this.venta_id = venta_id;
    }
    // Getters y Setters
    public Venta getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(Venta venta_id) {
        this.venta_id = venta_id;
    }

    public Producto getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        this.producto_id = producto_id;
    }

    
    



}
