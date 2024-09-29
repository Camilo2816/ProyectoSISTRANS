package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.EspecificacionEmpaquetado;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE id= : id", nativeQuery = true)
    Producto darProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (nombre, costoBodega, precioUnitario, presentacion, cantidadPresentacion, unidadMedida, codigoBarras, fechaVencimiento, categoria_id, especificacionEmpaquetado_id) VALUES(PRODUCTO_PRODUCTO_ID_SEQ.nextval, :nombre, :costoBodega, :precioUnitario, :presentacion, :cantidadPresentacion, :unidadMedida, :codigoBarras, :fechaVencimiento, :categoria_id, :especificacionEmpaquetado_id)", nativeQuery = true)
    void insertarProducto(@Param("nombre")String nombre, @Param("costoBodega")Float costoBodega, @Param("precioUnitario") Float precioUnitario, @Param("presentacion")String presentacion, @Param("cantidadPresentacion")Integer cantidadPresentacion, @Param("unidadMedida")String unidadMedida, @Param("codigoBarras")Integer codigoBarras, @Param("fechaVencimiento")Date fechaVencimiento, @Param("categoria")Categoria categoria_id, @Param("especificacion de empaquetado")EspecificacionEmpaquetado especificacionEmpaquetado_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre=:nombre, costoBodega=:costoBodega, precioUnitario=:precioUnitario, presentacion=:presentacion, cantidadPresentacion=:cantidadPresentacion, unidadMedida=:unidadMedida, codigoBarras=:codigoBarras, fechaVencimiento=:fechaVencimiento, categoria_id=:categoria_id, especificacionEmpaquetado_id=:especificacionEmpaquetado_id WHERE id=:id", nativeQuery = true)
    void actualizarProducto(@Param("id") int id, @Param("nombre")String nombre, @Param("costoBodega")Float costoBodega, @Param("precioUnitario") Float precioUnitario, @Param("presentacion")String presentacion, @Param("cantidadPresentacion")Integer cantidadPresentacion, @Param("unidadMedida")String unidadMedida, @Param("codigoBarras")Integer codigoBarras, @Param("fechaVencimiento")Date fechaVencimiento, @Param("categoria")Categoria categoria_id, @Param("especificacion de empaquetado")EspecificacionEmpaquetado especificacionEmpaquetado_id);

    @Modifying
    @Transactional
    @Query(value = "Delete FROM productos WHERE id =: id", nativeQuery = true)
    void eliminarBar(@Param("id") int id);
}
