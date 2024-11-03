package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.DocumentoRecepcion;
import java.util.List;





//funciones de repositorio de DocumentoRecepcionRepository, acceden a los cruds necesarios 
public interface DocumentoRecepcionRepository extends JpaRepository<DocumentoRecepcion, Integer> {
    
    @Query(value = "SELECT * FROM documentorecepcion", nativeQuery = true)
    Collection<DocumentoRecepcion> darDocumentosRecepcion();

    @Query(value = "SELECT * FROM documentorecepcion WHERE id = :id", nativeQuery = true)
    DocumentoRecepcion darDocumentoRecepcion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO documentorecepcion (fechaEntregado) VALUES (SEQ_DOC_ENTREGA_ID.nextval, :fechaEntregado)", nativeQuery = true)
    void insertarDocumentoRecepcion(@Param("fechaEntregado") Date fechaEntregado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE documentorecepcion SET fechaEntregado = :fechaEntregado WHERE id = :id", nativeQuery = true)
    void actualizarDocumentoRecepcion(@Param("id") int id, @Param("fechaEntregado") Date fechaEntregado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM documentorecepcion WHERE id = :id", nativeQuery = true)
    void eliminarDocumentoRecepcion(@Param("id") int id);

    @Query(value = "SELECT * FROM documentorecepcion WHERE bodega_bodega_id = :bodegaId", nativeQuery = true)
    List<DocumentoRecepcion> findByIdBodega(@Param("bodegaId") int bodegaId);
}
