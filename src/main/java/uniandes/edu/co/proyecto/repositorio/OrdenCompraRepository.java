package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;


//funciones de repositorio de OrdenCompraRepository, acceden a los cruds necesarios 
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {

    @Query(value = "SELECT * FROM orden_compra", nativeQuery = true)
    Collection<OrdenCompra> darOrdenesCompra();
//inicialización de cada atributo dentro del sistema
    @Query(value = "SELECT * FROM orden_compra WHERE ORDENCOMPRA_ID = :id", nativeQuery = true)
    OrdenCompra darOrdenCompra(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO orden_compra (cantidad, precio, fechaEntrega, estado) VALUES (ORDENCOMPRA_ORDENCOMPRA_ID_SEQ.nextval, :cantidad, :precio, :fechaEntrega, :estado)", nativeQuery = true)
    void insertarOrdenCompra(@Param("cantidad") Integer cantidad, @Param("precio") Float precio, @Param("fechaEntrega") Date fechaEntrega, @Param("estado") String estado);


    @Modifying
    @Transactional
    @Query(value = "UPDATE orden_compra SET cantidad = :cantidad, precio = :precio, fechaEntrega = :fechaEntrega, estado = :estado WHERE ORDENCOMPRA_ID = :id", nativeQuery = true)
    void actualizarOrdenCompra(@Param("id") int id, @Param("cantidad") Integer cantidad, @Param("precio") Float precio, @Param("fechaEntrega") Date fechaEntrega, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM orden_compra WHERE ORDENCOMPRA_ID = :id", nativeQuery = true)
    void eliminarOrdenCompra(@Param("id") int id);
}
