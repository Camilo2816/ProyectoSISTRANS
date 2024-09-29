package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
    
    @Query(value = "SELECT * FROM ciudades", nativeQuery = true)
    Collection<Ciudad> darCiudades();

    @Query(value = "SELECT * FROM ciudades WHERE id= : id", nativeQuery = true)
    Ciudad darCiudad(@Param("id") int id);
}
