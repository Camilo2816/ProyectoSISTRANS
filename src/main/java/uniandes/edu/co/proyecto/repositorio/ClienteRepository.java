package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;



//funciones de repositorio de ClienteRepository, acceden a los cruds necesarios 
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM cliente WHERE id = :id", nativeQuery = true)
    Cliente darCliente(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cliente (nombre, cedula) VALUES (CLIENTE_CLIENTE_ID_SEQ.nextval, :nombre, :cedula)", nativeQuery = true)
    void insertarCliente(@Param("nombre") String nombre, @Param("cedula") String cedula);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cliente SET nombre = :nombre, cedula = :cedula WHERE id = :id", nativeQuery = true)
    void actualizarCliente(@Param("id") int id, @Param("nombre") String nombre, @Param("cedula") String cedula);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cliente WHERE id = :id", nativeQuery = true)
    void eliminarCliente(@Param("id") int id);
}
