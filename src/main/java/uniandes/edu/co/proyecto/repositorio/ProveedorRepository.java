package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    
    @Query(value = "SELECT * FROM proveedor", nativeQuery = true)
    Collection<Proveedor> darProveedores();

    @Query(value = "SELECT * FROM proveedor WHERE PROVEEDOR_ID = :id", nativeQuery = true)
    Proveedor darProveedor(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proveedor (nit, nombre, direccion, personaContacto, telefono, PROVEEDOR_ID) VALUES (:nit, :nombre, :direccion, :personaContacto, :telefono, SEQUENCEPROVEDOR_ID.nextval)", nativeQuery = true)
    void insertarProveedor(@Param("nit") String nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("personaContacto") String personaContacto, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedor SET nit = :nit, nombre = :nombre, direccion = :direccion, personaContacto = :personaContacto, telefono = :telefono WHERE PROVEEDOR_ID = :id", nativeQuery = true)
    void actualizarProveedor(@Param("id") int id, @Param("nit") String nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("personaContacto") String personaContacto, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM proveedor WHERE PROVEEDOR_ID = :id", nativeQuery = true)
    void eliminarProveedor(@Param("id") int id);
}
