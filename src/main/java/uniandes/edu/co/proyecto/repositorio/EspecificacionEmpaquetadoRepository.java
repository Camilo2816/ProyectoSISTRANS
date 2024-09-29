package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.EspecificacionEmpaquetado;

public interface EspecificacionEmpaquetadoRepository extends JpaRepository<EspecificacionEmpaquetado, Integer> {
    
    @Query(value = "SELECT * FROM especificacion_de_empaquetado", nativeQuery = true)
    Collection<EspecificacionEmpaquetado> darEspecificacionesEmpaquetado();

    @Query(value = "SELECT * FROM especificacion_de_empaquetado WHERE id = :id", nativeQuery = true)
    EspecificacionEmpaquetado darEspecificacionEmpaquetado(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO especificacion_de_empaquetado (volumen, peso) VALUES (:volumen, :peso)", nativeQuery = true)
    void insertarEspecificacionEmpaquetado(@Param("volumen") Integer volumen, @Param("peso") Integer peso);

    @Modifying
    @Transactional
    @Query(value = "UPDATE especificacion_de_empaquetado SET volumen = :volumen, peso = :peso WHERE id = :id", nativeQuery = true)
    void actualizarEspecificacionEmpaquetado(@Param("id") int id, @Param("volumen") Integer volumen, @Param("peso") Integer peso);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM especificacion_de_empaquetado WHERE id = :id", nativeQuery = true)
    void eliminarEspecificacionEmpaquetado(@Param("id") int id);
}
