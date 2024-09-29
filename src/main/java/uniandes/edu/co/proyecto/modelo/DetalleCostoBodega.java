package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "detallecostobodega")
public class DetalleCostoBodega {

    @EmbeddedId
    private DetalleCostoBodegaPK PK;

    @Column(name = "costo_unitario_bod") // Asegúrate de que coincida con el nombre de la columna en la base de datos
    private Integer costoUnitarioBod;

    @Column(name = "cantidad_existencias") // Asegúrate de que coincida con el nombre de la columna en la base de datos
    private Integer cantidadExistencias;

    public DetalleCostoBodega(Integer costoUnitarioBod, Bodega bodega_id, Producto producto_id, Integer cantidadExistencias) {
        this.costoUnitarioBod = costoUnitarioBod;
        this.cantidadExistencias = cantidadExistencias;
        this.PK = new DetalleCostoBodegaPK(bodega_id, producto_id);
    }

    public DetalleCostoBodega() {
    }

    public Integer getCostoUnitarioBod() {
        return costoUnitarioBod;
    }

    public void setCostoUnitarioBod(Integer costoUnitarioBod) {
        this.costoUnitarioBod = costoUnitarioBod;
    }

    public Integer getCantidadExistencias() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(Integer cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    public DetalleCostoBodegaPK getPK() {
        return PK;
    }

    public void setPK(DetalleCostoBodegaPK PK) {
        this.PK = PK;
    }
}
