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

    @Query(value = "SELECT * FROM sucursal WHERE SUCURSAL_ID = :id", nativeQuery = true)
    Sucursal darSucursal(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursal (nombre, tamaño, telefono, direccion, SUCURSAL_ID, CIUDAD_CIUDAD_ID) VALUES (:nombre, :tamanio, :telefono, :direccion, SUCURSAL_SUCURSAL_ID_SEQ.nextval, :ciudadId)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamanio") float tamanio, @Param("telefono") String telefono  ,@Param("direccion") String direccion  ,@Param("ciudadId") Integer ciudadId);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursal SET nombre = :nombre, tamaño = :tamanio, telefono = :telefono, direccion = :direccion,  CIUDAD_CIUDAD_ID = :ciudadId  WHERE SUCURSAL_ID = :id", nativeQuery = true)
    void actualizarSucursal(@Param("id") int id, @Param("nombre") String nombre, @Param("tamanio") float tamanio, @Param("telefono") String telefono, @Param("direccion") String direccion, @Param("ciudadId") Integer ciudadId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursal WHERE SUCURSAL_ID = :id", nativeQuery = true)
    void eliminarSucursal(@Param("id") int id);
}
