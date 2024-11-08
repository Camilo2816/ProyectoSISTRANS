package uniandes.edu.co.proyecto.repositorio;

import java.lang.StackWalker.Option;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;
import uniandes.edu.co.proyecto.modelo.InfoExtraOrdenPK;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;




//funciones de repositorio de InfoExtraOrdenRepository, acceden a los cruds necesarios 
public interface InfoExtraOrdenRepository extends JpaRepository<InfoExtraOrden, InfoExtraOrdenPK> {

    List<InfoExtraOrden> findByPK_OrdenCompra(OrdenCompra ordenCompra);

    
    @Query(value = "SELECT * FROM infoextraorden", nativeQuery = true)
    Collection<InfoExtraOrden> darInfoExtraOrdenes();

    @Query(value = "SELECT * FROM infoextraorden WHERE orden_id = :ordenId AND producto_id = :productoId", nativeQuery = true)
    InfoExtraOrden darInfoExtraOrden(@Param("ordenId") int ordenId, @Param("productoId") int productoId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO infoextraorden ( CANTIDAD, COSTOUNITARIO, PRODUCTO_PRODUCTO_ID, ORDENCOMPRA_ORDENCOMPRA_ID) VALUES (:cantidad, :costoUnitario, :productoId, :ordenId)", nativeQuery = true)
    void insertarInfoExtraOrden(@Param("ordenId") int ordenId, @Param("productoId") int productoId, @Param("cantidad") Long cantidad, @Param("costoUnitario") BigDecimal  costoUnitario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE infoextraorden SET CANTIDAD = :cantidad, COSTOUNITARIO = :costoUnitario WHERE ORDENCOMPRA_ORDEN_ID = :ordenId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void actualizarInfoExtraOrden(@Param("ordenId") int ordenId, @Param("productoId") int productoId, @Param("cantidad") Long cantidad, @Param("costoUnitario") BigDecimal  costoUnitario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM infoextraorden WHERE ORDENCOMPRA_ORDEN_ID = :ordenId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void eliminarInfoExtraOrden(@Param("ordenId") int ordenId, @Param("productoId") int productoId);
}
