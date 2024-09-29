package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.InfoExtraBodega;
import uniandes.edu.co.proyecto.modelo.InfoExtraBodegaPK;

public interface InfoExtraBodegaRepository extends JpaRepository<InfoExtraBodega, InfoExtraBodegaPK> {

    @Query(value = "SELECT * FROM infoextrabodega", nativeQuery = true)
    Collection<InfoExtraBodega> darInfoExtraBodegas();

    @Query(value = "SELECT * FROM infoextrabodega WHERE bodega_id = :bodegaId AND producto_id = :productoId", nativeQuery = true)
    InfoExtraBodega darInfoExtraBodega(int bodegaId, int productoId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO infoextrabodega (TOTALEXISTENCIAS, COSTOPROMEDIO, CAPACIDADALMACENAMIENTO, NIVELMINIMOREORDEN, BODEGA_BODEGA_ID, PRODUCTO_PRODUCTO_ID) VALUES (:totalExistencias, :costoPromedio, :capacidadAlmacenamiento, :nivelMinimoReorden, :bodegaId, :productoId)", nativeQuery = true)
    void insertarInfoExtraBodega(@Param("bodegaId") int bodegaId, @Param("productoId") int productoId, @Param("totalExistencias") int totalExistencias, @Param("costoPromedio") float costoPromedio, @Param("capacidadAlmacenamiento") int capacidadAlmacenamiento, @Param("nivelMinimoReorden") int nivelMinimoReorden);

    @Modifying
    @Transactional
    @Query(value = "UPDATE infoextrabodega SET TOTALEXISTENCIAS = :totalExistencias, COSTOPROMEDIO = :costoPromedio, CAPACIDADALMACENAMIENTO = :capacidadAlmacenamiento, NIVELMINIMOREORDEN = :nivelMinimoReorden WHERE BODEGA_BODEGA_ID = :bodegaId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void actualizarInfoExtraBodega(@Param("bodegaId") int bodegaId, @Param("productoId") int productoId, @Param("totalExistencias") int totalExistencias, @Param("costoPromedio") float costoPromedio, @Param("capacidadAlmacenamiento") int capacidadAlmacenamiento, @Param("nivelMinimoReorden") int nivelMinimoReorden);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM infoextrabodega WHERE BODEGA_BODEGA_ID = :bodegaId AND PRODUCTO_PRODUCTO_ID = :productoId", nativeQuery = true)
    void eliminarInfoExtraBodega(@Param("bodegaId") int bodegaId, @Param("productoId") int productoId);
}
