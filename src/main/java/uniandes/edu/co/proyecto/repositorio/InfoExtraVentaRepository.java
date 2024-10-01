package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.InfoExtraVenta;
import uniandes.edu.co.proyecto.modelo.InfoExtraVentaPK;

//funciones de repositorio de InfoExtraRepository, acceden a los cruds necesarios 
public interface InfoExtraVentaRepository extends JpaRepository<InfoExtraVenta, InfoExtraVentaPK> {
	
	
    @Query(value = "SELECT * FROM infoextraventa", nativeQuery = true)
    Collection<InfoExtraVenta> darInfoExtraVentas();

    
    @Query(value = "SELECT * FROM infoextraventa WHERE venta_id = :ventaId AND producto_id = :productoId", nativeQuery = true)
    InfoExtraVenta darInfoExtraVenta(@Param("ventaId") int ventaId, @Param("productoId") int productoId);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO infoextraventa (CANTIDAD, PRECIOUNITARIOVENTA, VENTA_VENTA_ID, PRODUCTO_PRODUCTO_ID) VALUES (:cantidad, :precioUnitario, :ventaId, :productoId)", nativeQuery = true)
    void insertarInfoExtraVenta(@Param("cantidad") int cantidad, @Param("precioUnitario") float precioUnitario, @Param("ventaId") int ventaId, @Param("productoId") int productoId);


    @Modifying
    @Transactional
    @Query(value = "UPDATE infoextraventa SET CANTIDAD = :cantidad, PRECIOUNITARIOVENTA = :precioUnitario WHERE VENTA_VENTA_ID = :ventaId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void actualizarInfoExtraVenta(@Param("cantidad") int cantidad, @Param("precioUnitario") float precioUnitario, @Param("ventaId") int ventaId, @Param("productoId") int productoId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM infoextraventa WHERE VENTA_VENTA_ID = :ventaId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void eliminarInfoExtraVenta(@Param("ventaId") int ventaId, @Param("productoId") int productoId);    
}
