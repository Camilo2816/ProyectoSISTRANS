package uniandes.edu.co.proyecto.Services;

import uniandes.edu.co.proyecto.modelo.DocumentoRecepcion;
import uniandes.edu.co.proyecto.repositorio.DocumentoRecepcionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentoIngresoPService {

    @Autowired
    private DocumentoRecepcionRepository documentoRecepcionRepository;

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public List<DocumentoRecepcion> consultarDocumentosSerializable(Integer bodegaId) throws InterruptedException {
        try {
            // Primera consulta a la base de datos
            List<DocumentoRecepcion> documentos = documentoRecepcionRepository.findByIdBodega(bodegaId);
            System.out.println("Cantidad de documentos en SERIALIZABLE: " + documentos.size());

            // Simulación de operación prolongada para mantener el bloqueo
            Thread.sleep(30000);

            // Segunda consulta a la base de datos (para verificar que no ocurran cambios)
            documentos = documentoRecepcionRepository.findByIdBodega(bodegaId);
            return documentos;

        } catch (InterruptedException e) {
            System.err.println("Error en consultarDocumentosSerializable: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
            return null;
        } 
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public List<DocumentoRecepcion> consultarDocumentosReadCommitted(Integer bodegaId) throws InterruptedException {

        try {
            // Primera consulta a la base de datos
            List<DocumentoRecepcion> documentos = documentoRecepcionRepository.findByIdBodega(bodegaId);
            System.out.println("Cantidad de documentos en READ_COMMITTED: " + documentos.size());

            // Simulación de operación prolongada para mantener el bloqueo
            Thread.sleep(30000);

            // Segunda consulta a la base de datos (para observar posibles cambios)
            documentos = documentoRecepcionRepository.findByIdBodega(bodegaId);
            return documentos;

        } catch (InterruptedException e) {
            System.err.println("Error en consultarDocumentosReadCommitted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
            return null;
        }
    }
}
