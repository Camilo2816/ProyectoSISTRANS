package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InfoExtraProveedorPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "proveedor_id" , referencedColumnName = "PROVEEDOR_ID")
    private Proveedor proveedor_id;

    @ManyToOne
    @JoinColumn(name = "producto_id" , referencedColumnName = "PRODUCTO_ID")
    private Producto producto_id;

    public InfoExtraProveedorPK(Proveedor proveedor_id, Producto producto_id) {
        super();
        this.producto_id = producto_id;
        this.proveedor_id = proveedor_id;
    }

    public Proveedor getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Proveedor proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public Producto getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        this.producto_id = producto_id;
    }





}
