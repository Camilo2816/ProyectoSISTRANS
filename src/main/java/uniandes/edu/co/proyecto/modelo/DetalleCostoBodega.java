package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

import jakarta.persistence.Column;

@Entity
@Table(name = "detallecostobodega")
public class DetalleCostoBodega {

    @EmbeddedId
    private DetalleCostoBodegaPK PK;

    @Column(name = "COSTOUNITARIOBOD") 
    private BigDecimal costoUnitarioBod;

    @Column(name = "CANTEXISTENCIAS") 
    private Long cantidadExistencias;
   // Constructores

    public DetalleCostoBodega(BigDecimal costoUnitarioBod, Bodega bodega_id, Producto producto_id, Long cantidadExistencias) {
        this.costoUnitarioBod = costoUnitarioBod;
        this.cantidadExistencias = cantidadExistencias;
        this.PK = new DetalleCostoBodegaPK(bodega_id, producto_id);
    }

    public DetalleCostoBodega() {
    }

        // Getters y Setters
    public BigDecimal getCostoUnitarioBod() {
        return costoUnitarioBod;
    }

    public void setCostoUnitarioBod(BigDecimal costoUnitarioBod) {
        this.costoUnitarioBod = costoUnitarioBod;
    }

    public Long getCantidadExistencias() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(Long cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    public DetalleCostoBodegaPK getPK() {
        return PK;
    }

    public void setPK(DetalleCostoBodegaPK PK) {
        this.PK = PK;
    }
}
