package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Venta;


//funciones de repositorio de VentaRepository, acceden a los cruds necesarios 
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query(value = "SELECT * FROM ventas", nativeQuery = true)
    Collection<Venta> darVentas();

    @Query(value = "SELECT * FROM ventas WHERE id = :id", nativeQuery = true)
    Venta darVenta(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ventas (id, fecha) VALUES (VENTA_VENTA_ID_SEQ.nextval, :fecha)", nativeQuery = true)
    void insertarVenta(@Param("fecha") Date fecha);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ventas SET fecha = :fecha WHERE id = :id", nativeQuery = true)
    void actualizarVenta(@Param("id") int id, @Param("fecha") Date fecha);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ventas WHERE id = :id", nativeQuery = true)
    void eliminarVenta(@Param("id") int id);

    //estas funciones son las especificadas por coursera
}
