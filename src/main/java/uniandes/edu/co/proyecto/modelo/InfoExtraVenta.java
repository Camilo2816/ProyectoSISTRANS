package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "infoextraventa")
public class InfoExtraVenta {

    private Integer cantidad;
    private float precioUnitario;
    @EmbeddedId
    private InfoExtraVentaPK PK;

    public InfoExtraVenta(Producto id_producto, Venta venta_id, Integer cantidad, float precioUnitario)
    {
        this.PK = new InfoExtraVentaPK(venta_id, id_producto);
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public InfoExtraVenta()
    {;}

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public InfoExtraVentaPK getPK() {
        return PK;
    }

    public void setPK(InfoExtraVentaPK pK) {
        PK = pK;
    }

    

    

}
