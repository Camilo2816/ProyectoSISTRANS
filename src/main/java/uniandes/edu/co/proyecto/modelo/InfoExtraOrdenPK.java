package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Embeddable
public class InfoExtraOrdenPK  implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ordenCompra_id" , referencedColumnName = "ORDENCOMPRA_ID")
    private OrdenCompra ordenCompra_id;

    @ManyToOne
    @JoinColumn(name = "producto_id" , referencedColumnName = "PRODUCTO_ID")
    private Producto producto_id;
   // Constructores

    public InfoExtraOrdenPK(OrdenCompra ordenCompra_id, Producto producto_id) {
        super();
        this.ordenCompra_id = ordenCompra_id;
        this.producto_id = producto_id;
    }
    // Getters y Setters
    public void setOrdenCompra_id(OrdenCompra ordenCompra_id) {
        this.ordenCompra_id = ordenCompra_id;
    }

    public void setProducto_id(Producto producto_id) {
        this.producto_id = producto_id;
    }

    public OrdenCompra getOrdenCompra_id() {
        return ordenCompra_id;
    }

    public Producto getProducto_id() {
        return producto_id;
    }

    


    
}
