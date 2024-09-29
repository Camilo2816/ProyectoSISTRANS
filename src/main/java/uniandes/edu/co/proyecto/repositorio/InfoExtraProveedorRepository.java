package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.InfoExtraProveedor;
import uniandes.edu.co.proyecto.modelo.InfoExtraProveedorPK;

public interface InfoExtraProveedorRepository extends JpaRepository<InfoExtraProveedor, InfoExtraProveedorPK> {
	
    @Query(value = "SELECT * FROM infoextraproveedor", nativeQuery = true)
    Collection<InfoExtraProveedor> darInfoExtraProveedores();

    @Query(value = "SELECT * FROM infoextraproveedor WHERE proveedor_id = :proveedorId AND producto_id = :productoId", nativeQuery = true)
    InfoExtraProveedor darInfoExtraProveedor(@Param("proveedorId") int proveedorId, @Param("productoId") int productoId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO infoextraproveedor (CANTIDADEXISTENCIAS, PROVEEDOR_PROVEEDOR_ID, PRODUCTO_PRODUCTO_ID) VALUES (:cantidadExistencias, :proveedorId, :productoId)", nativeQuery = true)
    void insertarInfoExtraProveedor(@Param("proveedorId") int proveedorId, @Param("productoId") int productoId, @Param("cantidadExistencias") int cantidadExistencias);

    @Modifying
    @Transactional
    @Query(value = "UPDATE infoextraproveedor SET CANTIDADEXISTENCIAS = :cantidadExistencias WHERE PROVEEDOR_PROVEEDOR_ID = :proveedorId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void updateInfoExtraProveedor(@Param("proveedorId") int proveedorId, @Param("productoId") int productoId, @Param("cantidadExistencias") int cantidadExistencias);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM infoextraproveedor WHERE PROVEEDOR_PROVEEDOR_ID = :proveedorId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void eliminarInfoExtraProveedor(@Param("proveedorId") int proveedorId, @Param("productoId") int productoId);
}


