package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Collection;
import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
    @Query(value = "SELECT * FROM categorias ", nativeQuery = true)
    Collection<Categoria> darCategorias();

    @Query(value = "SELECT * FROM categorias  WHERE id= : id", nativeQuery = true)
    Categoria darCategoria(@Param("id") int id);
}
