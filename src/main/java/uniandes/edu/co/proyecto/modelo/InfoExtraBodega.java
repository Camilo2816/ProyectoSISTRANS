package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "infoextrabodega")
public class InfoExtraBodega {

    private Integer totalExistencias;
    private Float costoPromedio;
    private Integer capacidadAlmacenamiento;
    private Integer nivelMinimoReorden;
    @EmbeddedId
    private InfoExtraBodegaPK PK;

    public InfoExtraBodega(Producto producto_id, Bodega bodega_id, Integer totalExistencias, Float costoPromedio, Integer capacidadAlmacenamiento, Integer nivelMinimoReorden) {
        this.PK = new InfoExtraBodegaPK(bodega_id, producto_id);
        this.totalExistencias = totalExistencias;
        this.costoPromedio = costoPromedio;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    public InfoExtraBodega() 
    {;}

    public Integer getTotalExistencias() {
        return totalExistencias;
    }

    public void setTotalExistencias(Integer totalExistencias) {
        this.totalExistencias = totalExistencias;
    }

    public Float getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(Float costoPromedio) {
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

    public InfoExtraBodegaPK getPK() {
        return PK;
    }

    public void setPK(InfoExtraBodegaPK pK) {
        PK = pK;
    }

    



    


}
