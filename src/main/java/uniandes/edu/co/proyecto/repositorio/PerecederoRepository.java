package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Perecedero;



//funciones de repositorio de PerecederoRepository, acceden a los cruds necesarios 
public interface PerecederoRepository extends JpaRepository<Perecedero, Integer> {
    
    @Query(value = "SELECT * FROM perecedero", nativeQuery = true)
    Collection<Perecedero> darPerecederos();

    @Query(value = "SELECT * FROM perecedero WHERE id = :id", nativeQuery = true)
    Perecedero darPerecedero(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO perecedero (fechaVencimiento) VALUES (:fechaVencimiento)", nativeQuery = true)
    void insertarPerecedero(@Param("fechaVencimiento") Date fechaVencimiento);
//instrucción de fecha vencimiento siendo esta una date tipo (YYYY-MM-DD)

    @Modifying
    @Transactional
    @Query(value = "UPDATE perecedero SET fechaVencimiento = :fechaVencimiento WHERE id = :id", nativeQuery = true)
    void actualizarPerecedero(@Param("id") int id, @Param("fechaVencimiento") Date fechaVencimiento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM perecedero WHERE id = :id", nativeQuery = true)
    void eliminarPerecedero(@Param("id") int id);
}
