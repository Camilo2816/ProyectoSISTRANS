package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;


//funciones de repositorio de OrdenCompraRepository, acceden a los cruds necesarios 
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {

    @Query(value = "SELECT * FROM ordencompra", nativeQuery = true)
    Collection<OrdenCompra> darOrdenesCompra();
    
//inicialización de cada atributo dentro del sistema
    @Query(value = "SELECT * FROM ordencompra WHERE ORDENCOMPRA_ID = :id", nativeQuery = true)
    OrdenCompra darOrdenCompra(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordencompra (precio, fechaEntrega, estado, FechaCreacion, ordenCompra_id, proveedor_proveedor_id, sucursal_sucursal_id) VALUES (:precio, :fechaEntrega, 'Vigente', SYSDATE, ORDENCOMPRA_ORDENCOMPRA_ID_SEQ.nextval, :proveedor_id, :sucursal_id)", nativeQuery = true)
    void insertarOrdenCompra(@Param("precio") Float precio, @Param("fechaEntrega") Date fechaEntrega, @Param("proveedor_id") Integer proveedor_id, @Param("sucursal_id") Integer sucursal_id);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordencompra SET estado = 'Anulada' WHERE ORDENCOMPRA_ID = :id", nativeQuery = true)
    void actualizarOrdenCompra(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ordencompra WHERE ORDENCOMPRA_ID = :id", nativeQuery = true)
    void eliminarOrdenCompra(@Param("id") int id);
}
