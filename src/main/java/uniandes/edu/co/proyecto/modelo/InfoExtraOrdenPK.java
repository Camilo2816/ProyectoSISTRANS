package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Embeddable
public class InfoExtraOrdenPK  implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ORDENCOMPRA_ORDENCOMPRA_ID", referencedColumnName = "ORDENCOMPRA_ID") 
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "PRODUCTO_PRODUCTO_ID" , referencedColumnName = "PRODUCTO_ID")
    private Producto producto;
   // Constructores

    public InfoExtraOrdenPK(OrdenCompra ordenCompra_id, Producto producto_id) {
        super();
        this.ordenCompra = ordenCompra_id;
        this.producto= producto_id;
    }

    public InfoExtraOrdenPK() {
    }

    // Getters y Setters
    public void setOrdenCompra_id(OrdenCompra ordenCompra_id) {
        this.ordenCompra = ordenCompra_id;
    }

    public void setProducto_id(Producto producto_id) {
        this.producto = producto_id;
    }

    public OrdenCompra getOrdenCompra_id() {
        return ordenCompra;
    }

    public Producto getProducto_id() {
        return producto;
    }

    @Override
    public String toString() {
        return "InfoExtraOrdenPK{" +
                "ordenCompra_id=" + (ordenCompra != null ? ordenCompra.getId() : null) +
                ", producto_id=" + (producto != null ? producto.getId() : null) +
                '}';
}


    


    
}
