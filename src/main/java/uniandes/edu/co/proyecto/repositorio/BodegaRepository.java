package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega, Integer> {
    
    @Query(value = "SELECT * FROM bodega", nativeQuery = true)
    Collection<Bodega> darBodegas();

    @Query(value = "SELECT * FROM bodega WHERE BODEGA_ID = :id", nativeQuery = true) 
    Bodega darBodega(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodega (BODEGA_ID, nombre, tamanio, capacidad) VALUES (BODEGA_BODEGA_ID_SEQ.nextval, :nombre, :tamanio, :capacidad)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") Float tamanio, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bodega SET nombre = :nombre, tamanio = :tamanio, capacidad = :capacidad WHERE BODEGA_ID = :id", nativeQuery = true)
    void actualizarBodega(@Param("id") int id, @Param("nombre") String nombre, @Param("tamanio") Float tamanio, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodega WHERE BODEGA_ID = :id", nativeQuery = true)
    void eliminarBodega(@Param("id") int id);
}
