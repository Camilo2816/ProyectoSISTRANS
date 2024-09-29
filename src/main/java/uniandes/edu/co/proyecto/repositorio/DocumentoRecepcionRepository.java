package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.DocumentoRecepcion;

public interface DocumentoRecepcionRepository extends JpaRepository<DocumentoRecepcion, Integer> {
    
    @Query(value = "SELECT * FROM documento_recepcion", nativeQuery = true)
    Collection<DocumentoRecepcion> darDocumentosRecepcion();

    @Query(value = "SELECT * FROM documento_recepcion WHERE id = :id", nativeQuery = true)
    DocumentoRecepcion darDocumentoRecepcion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO documento_recepcion (fechaEntregado) VALUES (:fechaEntregado)", nativeQuery = true)
    void insertarDocumentoRecepcion(@Param("fechaEntregado") Date fechaEntregado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE documento_recepcion SET fechaEntregado = :fechaEntregado WHERE id = :id", nativeQuery = true)
    void actualizarDocumentoRecepcion(@Param("id") int id, @Param("fechaEntregado") Date fechaEntregado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM documento_recepcion WHERE id = :id", nativeQuery = true)
    void eliminarDocumentoRecepcion(@Param("id") int id);
}
