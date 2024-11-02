package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "infoextraorden")
public class InfoExtraOrden {

    @EmbeddedId
    private InfoExtraOrdenPK PK;
    private Integer cantidad;
    private float costoUnitario;
   // Constructores

    public InfoExtraOrden(Producto id_producto, OrdenCompra ordenCompra_id, Integer cantidad, float costoUnitario)
    {
        this.PK = new InfoExtraOrdenPK(ordenCompra_id, id_producto);
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public InfoExtraOrden()
    {;}
    
    // Getters y Setters
    public InfoExtraOrdenPK getPK() {
        return PK;
    }

    public void setPK(InfoExtraOrdenPK pK) {
        PK = pK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "InfoExtraOrden{" +
                "PK=" + PK +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                '}';
}

    
}
