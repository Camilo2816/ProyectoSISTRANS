package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Perecedero;

public interface PerecederoRepository extends JpaRepository<Perecedero, Integer> {
    
    @Query(value = "SELECT * FROM perecedero", nativeQuery = true)
    Collection<Perecedero> darPerecederos();

    @Query(value = "SELECT * FROM perecedero WHERE id = :id", nativeQuery = true)
    Perecedero darPerecedero(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO perecedero (nombre, costoBodega, precioUnitario, presentacion, cantidadPresentacion, unidadMedida, codigoBarras, fechaVencimiento) VALUES (PRODUCTO_PRODUCTO_ID_SEQ.nextval, :nombre, :costoBodega, :precioUnitario, :presentacion, :cantidadPresentacion, :unidadMedida, :codigoBarras, :fechaVencimiento)", nativeQuery = true)
    void insertarPerecedero(@Param("nombre") String nombre, @Param("costoBodega") Float costoBodega, @Param("precioUnitario") Float precioUnitario, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadMedida") String unidadMedida, @Param("codigoBarras") Integer codigoBarras, @Param("fechaVencimiento") Date fechaVencimiento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE perecedero SET nombre = :nombre, costoBodega = :costoBodega, precioUnitario = :precioUnitario, presentacion = :presentacion, cantidadPresentacion = :cantidadPresentacion, unidadMedida = :unidadMedida, codigoBarras = :codigoBarras, fechaVencimiento = :fechaVencimiento WHERE id = :id", nativeQuery = true)
    void actualizarPerecedero(@Param("id") int id, @Param("nombre") String nombre, @Param("costoBodega") Float costoBodega, @Param("precioUnitario") Float precioUnitario, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadMedida") String unidadMedida, @Param("codigoBarras") Integer codigoBarras, @Param("fechaVencimiento") Date fechaVencimiento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM perecedero WHERE id = :id", nativeQuery = true)
    void eliminarPerecedero(@Param("id") int id);
}
