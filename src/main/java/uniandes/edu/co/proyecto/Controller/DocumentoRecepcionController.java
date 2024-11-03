package uniandes.edu.co.proyecto.Controller;

//rojito

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.proyecto.Services.DocumentoIngresoPService;
import uniandes.edu.co.proyecto.Services.IngresoProductoService;
import uniandes.edu.co.proyecto.modelo.DocumentoRecepcion;
import uniandes.edu.co.proyecto.repositorio.DocumentoRecepcionRepository;

@RestController
public class DocumentoRecepcionController {

    @Autowired
    private DocumentoRecepcionRepository documentoRecepcionRepository;

    @Autowired
    private IngresoProductoService ingresoProductoService;

    @Autowired
    private DocumentoIngresoPService documentoIngresoPService;


    // Obtiene una colección de documentos de recepción
    @GetMapping("/documentosRecepcion")
    public Collection<DocumentoRecepcion> documentosRecepcion() {
        return documentoRecepcionRepository.darDocumentosRecepcion();
    }

    // Guarda un nuevo documento de recepción
    @PostMapping("/documentosRecepcion/new/save")
    public ResponseEntity<String> documentoRecepcionGuardar(@RequestBody DocumentoRecepcion documentoRecepcion) {
        try {
            documentoRecepcionRepository.insertarDocumentoRecepcion(documentoRecepcion.getFechaEntregado());
            return new ResponseEntity<>("DocumentoRecepcion creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el documentoRecepcion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualiza un documento de recepción existente
    @PostMapping("/documentosRecepcion/{id}/edit/save")
    public ResponseEntity<String> documentoRecepcionEditarGuardar(@PathVariable("id") Integer id, @RequestBody DocumentoRecepcion documentoRecepcion) {
        try {
            documentoRecepcionRepository.actualizarDocumentoRecepcion(id, documentoRecepcion.getFechaEntregado());
            return new ResponseEntity<>("DocumentoRecepcion actualizado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el documentoRecepcion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Elimina un documento de recepción por ID
    @GetMapping("/documentosRecepcion/{id}/delete")
    public ResponseEntity<String> documentoRecepcionEliminar(@PathVariable("id") Integer id) {
        try {
            documentoRecepcionRepository.eliminarDocumentoRecepcion(id);
            return new ResponseEntity<>("DocumentoRecepcion eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el documentoRecepcion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/documentosRecepcion/registrarIngresoProductos")
    public ResponseEntity<String> registrarIngresoProductos(
            @RequestParam Integer bodegaId,
            @RequestParam Integer ordenCompraId) {
        try {
            ingresoProductoService.registrarIngresoProductos(bodegaId, ordenCompraId);
            return ResponseEntity.ok("Ingreso de productos registrado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar ingreso de productos: " + e.getMessage());
        }
    }    

    // RFC6: Consulta documentos de recepción con nivel de aislamiento SERIALIZABLE
    @GetMapping("/documentosRecepcion/serializable")
    public ResponseEntity<List<DocumentoRecepcion>> consultarDocumentosSerializable(@RequestParam Integer bodegaId) throws InterruptedException {
            List<DocumentoRecepcion> documentos = documentoIngresoPService.consultarDocumentosSerializable(bodegaId);
            return new ResponseEntity<>(documentos, HttpStatus.OK);
    }

    // RFC7: Consulta documentos de recepción con nivel de aislamiento READ COMMITTED
    @GetMapping("/documentosRecepcion/readCommitted")
    public ResponseEntity<List<DocumentoRecepcion>> consultarDocumentosReadCommitted(@RequestParam Integer bodegaId) throws InterruptedException {
            List<DocumentoRecepcion> documentos = documentoIngresoPService.consultarDocumentosReadCommitted(bodegaId);
            return new ResponseEntity<>(documentos, HttpStatus.OK);
        
    }

}
