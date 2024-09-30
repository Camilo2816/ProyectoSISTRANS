package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
    @Query(value = "SELECT * FROM categoria", nativeQuery = true)
    Collection<Categoria> darCategorias();

    @Query(value = "SELECT * FROM categoria WHERE CATEGORIA_ID = :id", nativeQuery = true)
    Categoria darCategoria(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categoria (nombre, descripcion, caracteristicasAlmacenamiento, CATEGORIA_ID) VALUES (:nombre, :descripcion, :caracteristicasAlmacenamiento, CATEGORIA_CATEGORIA_ID_SEQ.nextval)", nativeQuery = true)
    void insertarCategoria(@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicasAlmacenamiento") String caracteristicasAlmacenamiento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE categoria SET nombre = :nombre, descripcion = :descripcion, caracteristicasAlmacenamiento = :caracteristicasAlmacenamiento WHERE CATEGORIA_ID = :id", nativeQuery = true)
    void actualizarCategoria(@Param("id") int id, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicasAlmacenamiento") String caracteristicasAlmacenamiento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM categoria WHERE CATEGORIA_ID = :id", nativeQuery = true)
    void eliminarCategoria(@Param("id") int id);
}
