package uniandes.edu.co.proyecto.repositorio;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.EspecificacionEmpaquetado;
import uniandes.edu.co.proyecto.modelo.Producto;


//funciones de repositorio de Producto repository, acceden a los cruds necesarios 
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    public interface ProductoProjection {
        Integer getProductoId();
        String getNombreProducto();
        BigDecimal getPrecioUnitario();
        Date getFechaExpiracion();
        String getNombreCategoria();
        String getNombreSucursal();
        Integer getExistencias();
    }
    
    
    @Query(value = "SELECT * FROM producto", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM producto WHERE PRODUCTO_ID = :id", nativeQuery = true)
    Producto darProducto(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto (Producto_id, nombre, costoEnBodega, precioUnitario, presentacion, cantidadPresentacion, unidadMedida ,codigoBarras, fechaExpiracion, CATEGORIA_CATEGORIA_ID, ESPECIFICACIONEMPAQUETADO_ID) VALUES(PRODUCTO_PRODUCTO_ID_SEQ.nextval, :nombre, :costoBodega, :precioUnitario, :presentacion, :cantidadPresentacion, :unidadMedida, :codigoBarras, :fechaVencimiento, :categoria_id, :especificacionEmpaquetado_id)", nativeQuery = true)
    void insertarProducto(@Param("nombre")String nombre, @Param("costoBodega")Float costoBodega, @Param("precioUnitario") Float precioUnitario, @Param("presentacion")String presentacion, @Param("cantidadPresentacion")Integer cantidadPresentacion, @Param("unidadMedida")String unidadMedida, @Param("codigoBarras")Integer codigoBarras, @Param("fechaVencimiento")Date fechaVencimiento, @Param("categoria_id")Integer categoria_id, @Param("especificacionEmpaquetado_id")Integer especificacionEmpaquetado_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET nombre=:nombre, costoEnBodega=:costoBodega, precioUnitario=:precioUnitario, presentacion=:presentacion, cantidadPresentacion=:cantidadPresentacion, unidadMedida=:unidadMedida, codigoBarras=:codigoBarras, fechaExpiracion=:fechaVencimiento, CATEGORIA_CATEGORIA_ID=:categoria_id, ESPECIFICACIONEMPAQUETADO_ID=:especificacionEmpaquetado_id WHERE PRODUCTO_ID= :id", nativeQuery = true)
    void actualizarProducto(@Param("id") int id, @Param("nombre") String nombre, @Param("costoBodega") Float costoBodega, @Param("precioUnitario") Float precioUnitario, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadMedida") String unidadMedida, @Param("codigoBarras") Integer codigoBarras, @Param("fechaVencimiento") Date fechaVencimiento, @Param("categoria_id") Integer categoria_id, @Param("especificacionEmpaquetado_id") Integer especificacionEmpaquetado_id);

    @Modifying
    @Transactional
    @Query(value = "Delete FROM producto WHERE PRODUCTO_ID =:id", nativeQuery = true)
    void eliminarBar(@Param("id") int id);

    
    @Query(value = "SELECT " +
    "p.producto_id AS productoId, " +
    "p.nombre AS nombreProducto, " +
    "p.preciounitario AS precioUnitario, " +
    "p.fechaexpiracion AS fechaExpiracion, " +
    "c.nombre AS nombreCategoria, " +
    "s.nombre AS nombreSucursal, " +
    "i.totalexistencias AS existencias " +
    "FROM Producto p " +
    "JOIN Categoria c ON p.categoria_categoria_id = c.categoria_id " +
    "JOIN InfoExtraBodega i ON i.producto_producto_id = p.producto_id " +
    "JOIN Bodega b ON i.bodega_bodega_id = b.bodega_id " +
    "JOIN Sucursal s ON b.sucursal_sucursal_id = s.sucursal_id " +
    "WHERE (:precioMin IS NULL OR p.preciounitario >= :precioMin) " +
    "AND (:precioMax IS NULL OR p.preciounitario <= :precioMax) " +
    "AND (:fechaExpiracion IS NULL OR p.fechaexpiracion <= :fechaExpiracion) " +
    "AND (:sucursalId IS NULL OR s.sucursal_id = :sucursalId) " +
    "AND (:categoriaId IS NULL OR c.categoria_id = :categoriaId)",
    nativeQuery = true)
    List<ProductoProjection> buscarProductos(
    @Param("precioMin") BigDecimal precioMin,
    @Param("precioMax") BigDecimal precioMax,
    @Param("fechaExpiracion") String fechaExpiracion,
    @Param("sucursalId") Integer sucursalId,
    @Param("categoriaId") Integer categoriaId);
}
