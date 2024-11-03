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
    void insertarProducto(@Param("nombre")String nombre, @Param("costoBodega")Float costoBodega, @Param("precioUnitario") Float precioUnitario, @Param("presentacion")String presentacion, @Param("cantidadPresentacion")Integer cantidadPresentacion, @Param("unidadMedida")String unidadMedida, @Param("codigoBarras")Long codigoBarras, @Param("fechaVencimiento")Date fechaVencimiento, @Param("categoria_id")Integer categoria_id, @Param("especificacionEmpaquetado_id")Integer especificacionEmpaquetado_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET nombre=:nombre, costoEnBodega=:costoBodega, precioUnitario=:precioUnitario, presentacion=:presentacion, cantidadPresentacion=:cantidadPresentacion, unidadMedida=:unidadMedida, codigoBarras=:codigoBarras, fechaExpiracion=:fechaVencimiento, CATEGORIA_CATEGORIA_ID=:categoria_id, ESPECIFICACIONEMPAQUETADO_ID=:especificacionEmpaquetado_id WHERE PRODUCTO_ID= :id", nativeQuery = true)
    void actualizarProducto(@Param("id") int id, @Param("nombre") String nombre, @Param("costoBodega") Float costoBodega, @Param("precioUnitario") Float precioUnitario, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadMedida") String unidadMedida, @Param("codigoBarras") Long codigoBarras, @Param("fechaVencimiento") Date fechaVencimiento, @Param("categoria_id") Integer categoria_id, @Param("especificacionEmpaquetado_id") Integer especificacionEmpaquetado_id);

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




    @Query(value = "SELECT s.sucursal_id AS sucursalId, s.nombre AS nombreSucursal " +
                   "FROM Sucursal s " +
                   "JOIN Bodega b ON s.sucursal_id = b.sucursal_sucursal_id " +
                   "JOIN InfoExtraBodega i ON b.bodega_id = i.bodega_bodega_id " +
                   "JOIN Producto p ON i.producto_producto_id = p.producto_id " +
                   "WHERE p.producto_id = :productoId OR p.nombre = :nombre", nativeQuery = true)
    List<SucursalProjection> encontrarSucursalesPorProducto(
            @Param("productoId") Integer productoId,
            @Param("nombre") String nombre);
    
    public interface SucursalProjection {
        Integer getSucursalId();
        String getNombreSucursal();
    }


    @Query(value = "SELECT " +
    "p.producto_id AS productoId, " +
    "p.nombre AS nombreProducto, " +
    "b.nombre AS nombreBodega, " +
    "s.nombre AS nombreSucursal, " +
    "pr.nombre AS nombreProveedor, " +
    "i.totalexistencias AS cantidadActual " +
    "FROM Producto p " +
    "JOIN InfoExtraBodega i ON p.producto_id = i.producto_producto_id " +
    "JOIN Bodega b ON i.bodega_bodega_id = b.bodega_id " +
    "JOIN Sucursal s ON b.sucursal_sucursal_id = s.sucursal_id " +
    "LEFT JOIN OrdenCompra oc ON s.sucursal_id = oc.sucursal_sucursal_id " +
    "LEFT JOIN Proveedor pr ON oc.proveedor_proveedor_id = pr.proveedor_id " +
    "WHERE i.totalexistencias < i.nivelminimoreorden " +
    "ORDER BY p.producto_id, b.nombre, s.nombre", 
    nativeQuery = true)
    List<ProductoRequiereOrdenProjection> buscarProductosQueRequierenOrden();

    public interface ProductoRequiereOrdenProjection {
    Integer getProductoId();
    String getNombreProducto();
    String getNombreBodega();
    String getNombreSucursal();
    String getNombreProveedor();
    Integer getCantidadActual();
}
}
