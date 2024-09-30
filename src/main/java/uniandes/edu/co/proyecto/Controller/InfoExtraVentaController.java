package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.InfoExtraVenta;
import uniandes.edu.co.proyecto.repositorio.InfoExtraVentaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class InfoExtraVentaController {

    @Autowired 
    private InfoExtraVentaRepository infoExtraVentaRepository;

    @GetMapping("/InfoExtraVentas")
    public Collection<InfoExtraVenta> infoExtraVentas() {
        return infoExtraVentaRepository.darInfoExtraVentas();
    }   
    
    @PostMapping("/InfoExtraVentas/new/save")
    public ResponseEntity<String> infoExtraVentaGuardar(@RequestBody InfoExtraVenta infoExtraVenta) {
        try {
            infoExtraVentaRepository.insertarInfoExtraVenta(infoExtraVenta.getCantidad(), infoExtraVenta.getPrecioUnitario(), infoExtraVenta.getPK().getVenta_id().getId(), infoExtraVenta.getPK().getProducto_id().getId()
            );
            return new ResponseEntity<>("InfoExtraVenta creada exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear la InfoExtraVenta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/InfoExtraVentas/{ventaId}/{productoId}/edit/save")
    public ResponseEntity<String> infoExtraVentaEditarGuardar(@PathVariable("ventaId") Integer ventaId, @PathVariable("productoId") Integer productoId, @RequestBody InfoExtraVenta infoExtraVenta) {
        try {
            infoExtraVentaRepository.actualizarInfoExtraVenta(infoExtraVenta.getCantidad(), infoExtraVenta.getPrecioUnitario(), ventaId, productoId);
            return new ResponseEntity<>("InfoExtraVenta actualizada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la InfoExtraVenta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/InfoExtraVentas/{ventaId}/{productoId}/delete")
    public ResponseEntity<String> infoExtraVentaEliminar(@PathVariable("ventaId") Integer ventaId, @PathVariable("productoId") Integer productoId) {
        try {
            infoExtraVentaRepository.eliminarInfoExtraVenta(ventaId, productoId);
            return new ResponseEntity<>("InfoExtraVenta eliminada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la InfoExtraVenta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
