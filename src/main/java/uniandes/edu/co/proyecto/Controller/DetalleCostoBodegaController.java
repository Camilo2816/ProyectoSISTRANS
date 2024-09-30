package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.DetalleCostoBodega;
import uniandes.edu.co.proyecto.repositorio.DetalleCostoBodegaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DetalleCostoBodegaController {

    @Autowired 
    private DetalleCostoBodegaRepository detalleCostoBodegaRepository;

    @GetMapping("/DetalleCostoBodegas")
    public Collection<DetalleCostoBodega> darDetalleCostoBodegas() {
        return detalleCostoBodegaRepository.darDetalleCostoBodegas();
    }   
    
    @PostMapping("/DetalleCostoBodegas/new/save")
    public ResponseEntity<String> guardarDetalleCostoBodega(@RequestBody DetalleCostoBodega detalleCostoBodega) {
        try {
            detalleCostoBodegaRepository.insertarDetalleCostoBodega(detalleCostoBodega.getPK().getBodega_id().getId(),  detalleCostoBodega.getPK().getProducto_id().getId(), detalleCostoBodega.getCostoUnitarioBod(), detalleCostoBodega.getCantidadExistencias());
            return new ResponseEntity<>("Detalle de costo de bodega creado exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear el detalle de costo de bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/DetalleCostoBodegas/{bodegaId}/{productoId}/edit/save")
    public ResponseEntity<String> editarDetalleCostoBodega(@PathVariable("bodegaId") Integer bodegaId, @PathVariable("productoId") Integer productoId, @RequestBody DetalleCostoBodega detalleCostoBodega) {
        try {
            detalleCostoBodegaRepository.actualizarDetalleCostoBodega(bodegaId, productoId, detalleCostoBodega.getCostoUnitarioBod(), detalleCostoBodega.getCantidadExistencias()
            );
            return new ResponseEntity<>("Detalle de costo de bodega actualizado exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el detalle de costo de bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/DetalleCostoBodegas/{bodegaId}/{productoId}/delete")
    public ResponseEntity<String> eliminarDetalleCostoBodega(@PathVariable("bodegaId") Integer bodegaId, @PathVariable("productoId") Integer productoId) {
        try {
            detalleCostoBodegaRepository.eliminarDetalleCostoBodega(bodegaId, productoId);
            return new ResponseEntity<>("Detalle de costo de bodega eliminado exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el detalle de costo de bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

