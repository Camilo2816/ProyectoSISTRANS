package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class DetalleCostoBodegaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "bodega_bodega_id", referencedColumnName = "BODEGA_ID")
    private Bodega bodega_id;

    @ManyToOne
    @JoinColumn(name = "producto_producto_id", referencedColumnName = "PRODUCTO_ID")
    private Producto producto_id;
   // Constructores

    public DetalleCostoBodegaPK(Bodega bodega_id, Producto producto_id) {
        super();
        this.producto_id = producto_id;
        this.bodega_id = bodega_id;
    }
    
    public DetalleCostoBodegaPK() {
    }

    // Getters y Setters
    public Bodega getBodega_id() {
        return bodega_id;
    }

    public void setBodega_id(Bodega bodega_id) {
        this.bodega_id = bodega_id;
    }

    public Producto getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        this.producto_id = producto_id;
    }
}
