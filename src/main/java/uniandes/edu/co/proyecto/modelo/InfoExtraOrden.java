package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "infoextraorden")
public class InfoExtraOrden {

    @EmbeddedId
    private InfoExtraOrdenPK PK;

    @Column(name = "CANTIDAD")
    private Long cantidad;

    @Column(name = "COSTOUNITARIO")
    private BigDecimal costoUnitario;

    // Constructores

    public InfoExtraOrden(Producto id_producto, OrdenCompra ordenCompra_id, Long cantidad, BigDecimal costoUnitario) {
        this.PK = new InfoExtraOrdenPK(ordenCompra_id, id_producto);
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public InfoExtraOrden() {}

    // Getters y Setters
    public InfoExtraOrdenPK getPK() {
        return PK;
    }

    public void setPK(InfoExtraOrdenPK pK) {
        PK = pK;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
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
