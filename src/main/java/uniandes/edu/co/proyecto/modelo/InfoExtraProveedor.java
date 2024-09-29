package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "infoextraproveedor")
public class InfoExtraProveedor {

    @EmbeddedId
    private InfoExtraProveedorPK PK;

    private Integer cantidadExistencias;

    public InfoExtraProveedor(Proveedor proveedor_id, Producto producto_id, Integer cantidadExistencias) {
        this.PK = new InfoExtraProveedorPK(proveedor_id, producto_id);
        this.cantidadExistencias = cantidadExistencias;
    }

    public InfoExtraProveedor() 
    {;}

    public InfoExtraProveedorPK getPK() {
        return PK;
    }

    public void setPK(InfoExtraProveedorPK pK) {
        PK = pK;
    }

    public Integer getCantidadExistencias() {
        return cantidadExistencias;
    }

    public void setCantidadExistencias(Integer cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    






}
