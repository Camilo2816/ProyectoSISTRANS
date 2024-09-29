package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    
    @Query(value = "SELECT * FROM sucursal", nativeQuery = true)
    Collection<Sucursal> darSucursales();

    @Query(value = "SELECT * FROM sucursal WHERE id = :id", nativeQuery = true)
    Sucursal darSucursal(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursal (nombre, tamaño, telefono, direccion) VALUES (:nombre, :tamaño, :telefono, :direccion)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamaño") float tamaño, @Param("telefono") String telefono, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursal SET nombre = :nombre, tamaño = :tamaño, telefono = :telefono, direccion = :direccion WHERE id = :id", nativeQuery = true)
    void actualizarSucursal(@Param("id") int id, @Param("nombre") String nombre, @Param("tamaño") float tamaño, @Param("telefono") String telefono, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursal WHERE id = :id", nativeQuery = true)
    void eliminarSucursal(@Param("id") int id);
}
