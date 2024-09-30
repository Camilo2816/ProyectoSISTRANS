package uniandes.edu.co.proyecto.controller;

//rojito

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.proyecto.modelo.DocumentoRecepcion;
import uniandes.edu.co.proyecto.repositorio.DocumentoRecepcionRepository;


@RestController
public class DocumentoRecepcionController {

    @Autowired
    private DocumentoRecepcionRepository documentoRecepcionRepository;

    @GetMapping("/documentosRecepcion")
    public Collection<DocumentoRecepcion> documentosRecepcion() {
        return documentoRecepcionRepository.darDocumentosRecepcion();
    }
    
    @PostMapping("/documentosRecepcion/new/save")
    public ResponseEntity<String> documentoRecepcionGuardar(@RequestBody DocumentoRecepcion documentoRecepcion) {

        try {
            documentoRecepcionRepository.insertarDocumentoRecepcion(documentoRecepcion.getFechaEntregado());
            return new ResponseEntity<>("DocumentoRecepcion creado exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al crear el documentoRecepcion", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/documentosRecepcion/{id}/edit/save")
    public ResponseEntity<String> documentoRecepcionEditarGuardar(@PathVariable("id") Integer id,  @RequestBody DocumentoRecepcion documentoRecepcion) {

        try {
            documentoRecepcionRepository.actualizarDocumentoRecepcion(id, documentoRecepcion.getFechaEntregado());
            return new ResponseEntity<>("DocumentoRecepcion actualizado correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al actualizar el documentoRecepcion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/documentosRecepcion/{id}/delete")
    public ResponseEntity<String> documentoRecepcionEliminar(@PathVariable("id") Integer id) {

        try {
            documentoRecepcionRepository.eliminarDocumentoRecepcion(id);
            return new ResponseEntity<>("DocumentoRecepcion eliminado correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al eliminar el documentoRecepcion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
}
