package uniandes.edu.co.proyecto.repositorio;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Bodega;


//funciones de repositorio de BodegaRepository, acceden a los cruds necesarios 
public interface BodegaRepository extends JpaRepository<Bodega, Integer> {

    public interface RespuestaInformacionBodegasProjection {
    String getNombreBodega();
    String getNombreSucursal();
    BigDecimal getPorcentajeOcupacion();
    }

    
    @Query(value = "SELECT * FROM bodega", nativeQuery = true)
    Collection<Bodega> darBodegas();

    @Query(value = "SELECT * FROM bodega WHERE BODEGA_ID = :id", nativeQuery = true) 
    Bodega darBodega(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodega (nombre, tamaño, capacidad, BODEGA_ID, SUCURSAL_SUCURSAL_ID) VALUES ( :nombre, :tamanio, :capacidad, BODEGA_BODEGA_ID_SEQ.nextval, :sucursalId)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("capacidad") Integer capacidad, @Param("sucursalId") int sucursalId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bodega SET nombre = :nombre, tamanio = :tamanio, capacidad = :capacidad, SUCURSAL_SUCURSAL_ID = :sucursalId WHERE BODEGA_ID = :id", nativeQuery = true)
    void actualizarBodega(@Param("id") int id, @Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("capacidad") Integer capacidad, @Param("sucursalId") int sucursalId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodega WHERE BODEGA_ID = :id", nativeQuery = true)
    void eliminarBodega(@Param("id") int id);

    
    @Query(value = "SELECT b.nombre AS nombreBodega, " +
    "s.nombre AS nombreSucursal, " +
    "SUM((e.volumen / 1000000) * i.totalexistencias) / b.capacidad * 100 AS porcentajeOcupacion " +
    "FROM InfoExtraBodega i " +
    "JOIN Producto p ON i.producto_producto_id = p.producto_id " +
    "JOIN EspecificacionEmpaquetado e ON p.especificacionempaquetado_id = e.especificacionempaquetado_id " +
    "JOIN Bodega b ON i.bodega_bodega_id = b.bodega_id " +
    "JOIN Sucursal s ON b.sucursal_sucursal_id = s.sucursal_id " +
    "WHERE s.sucursal_id = :sucursalId AND i.producto_producto_id IN (:listaProductos) " +
    "GROUP BY b.nombre, s.nombre, b.capacidad", nativeQuery = true)
    List<RespuestaInformacionBodegasProjection> darBodegasOcupacion(@Param("sucursalId") Integer sucursalId, 
                                            @Param("listaProductos") List<Integer> listaProductos);





    /** 
    @Query(value = "SELECT b.nombre AS NOMBRE_BODEGA, s.nombre AS NOMBRE_SUCURSAL, SUM((e.volumen / 1000000) * i.totalexistencias) / b.capacidad * 100 AS PORCENTAJE_OCUPACION\r\n" +
    "FROM InfoExtraBodega i\r\n" +
    "JOIN Producto p ON i.producto_producto_id = p.producto_id\r\n" +
    "JOIN EspecificacionEmpaquetado e ON p.especificacionempaquetado_id = e.especificacionempaquetado_id\r\n" +
    "JOIN Bodega b ON i.bodega_bodega_id = b.bodega_id\r\n" +
    "JOIN Sucursal s ON b.sucursal_sucursal_id = s.sucursal_id\r\n" +
    "WHERE s.sucursal_id =: sucursal_id AND i.producto_producto_id IN (:lista_productos)\r\n" +
    "GROUP BY b.nombre, s.nombre, b.capacidad;", nativeQuery = true)
    Collection<Bodega> darBodegasOcupacion(@Param("sucursal_id") Integer sucursal_id, 
                                            @Param("lista_productos") List<Integer> lista_procuctos);

    @Query(value = "SELECT b.nombre AS NOMBRE_BODEGA, s.nombre AS NOMBRE_SUCURSAL, SUM((e.volumen / 1000000) * i.totalexistencias) / b.capacidad * 100 AS PORCENTAJE_OCUPACION\r\n" +
    "FROM InfoExtraBodega i\r\n" +
    "JOIN Producto p ON i.producto_producto_id = p.producto_id\r\n" +
    "JOIN EspecificacionEmpaquetado e ON p.especificacionempaquetado_id = e.especificacionempaquetado_id\r\n" +
    "JOIN Bodega b ON i.bodega_bodega_id = b.bodega_id\r\n" +
    "JOIN Sucursal s ON b.sucursal_sucursal_id = s.sucursal_id\r\n" +
    "WHERE s.sucursal_id =: sucursal_id AND i.producto_producto_id IN (:lista_productos)\r\n" +
    "GROUP BY b.nombre, s.nombre, b.capacidad", nativeQuery = true)
    Collection<RespuestaInformacionBodegas> darInformacionBodegas();**/
}
     
    
    
