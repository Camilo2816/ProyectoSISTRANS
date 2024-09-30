package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Venta;
import uniandes.edu.co.proyecto.repositorio.VentaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class VentaController {

    @Autowired 
    private VentaRepository ventaRepository;

    @GetMapping("/Ventas")
    public Collection<Venta> ventas() {
        return ventaRepository.darVentas();
    }   
    
    @PostMapping("/Ventas/new/save")
    public ResponseEntity<String> ventaGuardar(@RequestBody Venta venta) {
        try {
            ventaRepository.insertarVenta(venta.getFecha());
            return new ResponseEntity<>("Venta creada exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Ventas/{id}/edit/save")
    public ResponseEntity<String> VentaEditarGuardar(@PathVariable("id") Integer id, @RequestBody Venta venta) {
        try {
            ventaRepository.actualizarVenta(id, venta.getFecha());
            return new ResponseEntity<>("Venta actualizada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/Ventas/{id}/delete")
    public ResponseEntity<String> VentaEliminar(@PathVariable("id") Integer id) {
        try {
            ventaRepository.eliminarVenta(id);
            return new ResponseEntity<>("Venta eliminada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la venta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
