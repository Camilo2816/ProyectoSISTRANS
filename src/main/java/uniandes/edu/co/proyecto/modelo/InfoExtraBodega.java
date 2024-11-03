package uniandes.edu.co.proyecto.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "infoextrabodega")
public class InfoExtraBodega {

    @Column(name = "TOTALEXISTENCIAS")
    private Long totalExistencias;

    @Column(name = "COSTOPROMEDIO")
    private BigDecimal costoPromedio;

    @Column(name = "CAPACIDADALMACENAMIENTO")
    private Integer capacidadAlmacenamiento;

    @Column(name = "NIVELMINIMOREORDEN")
    private Integer nivelMinimoReorden;
    
    @EmbeddedId
    private InfoExtraBodegaPK PK;
   // Constructores

    public InfoExtraBodega(Producto producto_id, Bodega bodega_id, Long totalExistencias, BigDecimal costoPromedio, Integer capacidadAlmacenamiento, Integer nivelMinimoReorden) {
        this.PK = new InfoExtraBodegaPK(bodega_id, producto_id);
        this.totalExistencias = totalExistencias;
        this.costoPromedio = costoPromedio;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    public InfoExtraBodega()
    {;}
    // Getters y Setters
    public Long getTotalExistencias() {
        return totalExistencias;
    }

    public void setTotalExistencias(Long totalExistencias) {
        this.totalExistencias = totalExistencias;
    }

    public BigDecimal getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(BigDecimal costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public Integer getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(Integer capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public Integer getNivelMinimoReorden() {
        return nivelMinimoReorden;
    }

    public void setNivelMinimoReorden(Integer nivelMinimoReorden) {
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    public InfoExtraBodegaPK getPKBodega() {
        return PK;
    }

    public void setPK(InfoExtraBodegaPK pK) {
        PK = pK;
    }

    



    


}
