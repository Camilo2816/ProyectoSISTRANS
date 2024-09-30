package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.InfoExtraBodega;
import uniandes.edu.co.proyecto.repositorio.InfoExtraBodegaRepository;

@RestController
public class InfoExtraBodegaController {

    @Autowired 
    private InfoExtraBodegaRepository infoExtraBodegaRepository;

    @GetMapping("/InfoExtraBodegas")
    public Collection<InfoExtraBodega> infoExtraBodegas() {
        return infoExtraBodegaRepository.darInfoExtraBodegas();
    }   
    
    @PostMapping("/InfoExtraBodegas/new/save")
    public ResponseEntity<String> infoExtraBodegaGuardar(@RequestBody InfoExtraBodega infoExtraBodega) {
        try {
            infoExtraBodegaRepository.insertarInfoExtraBodega(infoExtraBodega.getPK().getBodega_id().getId(), infoExtraBodega.getPK().getProducto_id().getId(), infoExtraBodega.getTotalExistencias(), infoExtraBodega.getCostoPromedio(), infoExtraBodega.getCapacidadAlmacenamiento(), infoExtraBodega.getNivelMinimoReorden()
            );
            return new ResponseEntity<>("InfoExtraBodega creada exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear la InfoExtraBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/InfoExtraBodegas/{bodegaId}/{productoId}/edit/save")
    public ResponseEntity<String> infoExtraBodegaEditarGuardar(@PathVariable("bodegaId") Integer bodegaId, @PathVariable("productoId") Integer productoId, @RequestBody InfoExtraBodega infoExtraBodega) {
        try {
            infoExtraBodegaRepository.actualizarInfoExtraBodega(bodegaId, productoId, infoExtraBodega.getTotalExistencias(), infoExtraBodega.getCostoPromedio(), infoExtraBodega.getCapacidadAlmacenamiento(), infoExtraBodega.getNivelMinimoReorden()
            );
            return new ResponseEntity<>("InfoExtraBodega actualizada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la InfoExtraBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/InfoExtraBodegas/{bodegaId}/{productoId}/delete")
    public ResponseEntity<String> infoExtraBodegaEliminar(@PathVariable("bodegaId") Integer bodegaId, @PathVariable("productoId") Integer productoId) {
        try {
            infoExtraBodegaRepository.eliminarInfoExtraBodega(bodegaId, productoId);
            return new ResponseEntity<>("InfoExtraBodega eliminada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la InfoExtraBodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
