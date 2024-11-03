package uniandes.edu.co.proyecto.repositorio;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Sucursal;



//funciones de repositorio de Sucursal, acceden a los cruds necesarios 
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    

    public interface InventarioProjection {
    Integer getProductoId();
    String getNombreProducto();
    Integer getCantidadActual();
    Integer getCantidadMinima();
    BigDecimal getCostoPromedio();
    }

    @Query(value = "SELECT * FROM sucursal", nativeQuery = true)
    Collection<Sucursal> darSucursales();

    @Query(value = "SELECT * FROM sucursal WHERE SUCURSAL_ID = :id", nativeQuery = true)
    Sucursal darSucursal(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursal (nombre, tamaño, telefono, direccion, SUCURSAL_ID, CIUDAD_CIUDAD_ID) VALUES (:nombre, :tamanio, :telefono, :direccion, SUCURSAL_SUCURSAL_ID_SEQ.nextval, :ciudadId)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamanio") float tamanio, @Param("telefono") String telefono  ,@Param("direccion") String direccion  ,@Param("ciudadId") Integer ciudadId);
    
//función update requerida para las crud
    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursal SET nombre = :nombre, tamaño = :tamanio, telefono = :telefono, direccion = :direccion,  CIUDAD_CIUDAD_ID = :ciudadId  WHERE SUCURSAL_ID = :id", nativeQuery = true)
    void actualizarSucursal(@Param("id") int id, @Param("nombre") String nombre, @Param("tamanio") float tamanio, @Param("telefono") String telefono, @Param("direccion") String direccion, @Param("ciudadId") Integer ciudadId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursal WHERE SUCURSAL_ID = :id", nativeQuery = true)
    void eliminarSucursal(@Param("id") int id);


    @Query(value = "SELECT " +
    "p.producto_id AS productoId, " +
    "p.nombre AS nombreProducto, " +
    "i.totalexistencias AS cantidadActual, " +
    "i.NIVELMINIMOREORDEN AS cantidadMinima, " +
    "i.costopromedio AS costoPromedio " +
    "FROM Producto p " +
    "JOIN InfoExtraBodega i ON i.producto_producto_id = p.producto_id " +
    "JOIN Bodega b ON i.bodega_bodega_id = b.bodega_id " +
    "JOIN Sucursal s ON b.sucursal_sucursal_id = s.sucursal_id " +
    "WHERE s.sucursal_id = :sucursalId AND b.bodega_id = :bodegaId", 
    nativeQuery = true)
    List<InventarioProjection> obtenerInventario(@Param("sucursalId") Integer sucursalId, 
                                              @Param("bodegaId") Integer bodegaId);


                                              
}
