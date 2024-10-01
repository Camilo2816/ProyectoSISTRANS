package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.DetalleCostoBodega;
import uniandes.edu.co.proyecto.modelo.DetalleCostoBodegaPK;

public interface DetalleCostoBodegaRepository extends JpaRepository<DetalleCostoBodega, DetalleCostoBodegaPK> {


//funciones de repositorio de DetalleCostoBodegaRepository, acceden a los cruds necesarios 
    @Query(value = "SELECT * FROM detallecostobodega", nativeQuery = true)
    Collection<DetalleCostoBodega> darDetalleCostoBodegas();

    @Query(value = "SELECT * FROM detallecostobodega WHERE BODEGA_BODEGA_ID = :bodegaId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    DetalleCostoBodega darDetalleCostoBodega(int bodegaId, int productoId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO detallecostobodega (COSTOUNITARIOBOD, CANTIDADEXISTENCIAS, BODEGA_BODEGA_ID, PRODUCTO_PRODUCTO_ID) VALUES (:costoUnitarioBod, :cantidadExistencias, :bodegaId, :productoId)", nativeQuery = true)
    void insertarDetalleCostoBodega(@Param("bodegaId") int bodegaId, @Param("productoId") int productoId, @Param("costoUnitarioBod") float costoUnitarioBod, @Param("cantidadExistencias") int cantidadExistencias);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE detallecostobodega SET COSTOUNITARIOBOD = :costoUnitarioBod, CANTIDADEXISTENCIAS = :cantidadExistencias WHERE BODEGA_BODEGA_ID = :bodegaId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void actualizarDetalleCostoBodega(@Param("bodegaId") int bodegaId, @Param("productoId") int productoId, @Param("costoUnitarioBod") float costoUnitarioBod, @Param("cantidadExistencias") int cantidadExistencias);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM detallecostobodega WHERE BODEGA_BODEGA_ID = :bodegaId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void eliminarDetalleCostoBodega(@Param("bodegaId") int bodegaId, @Param("productoId") int productoId);
}
