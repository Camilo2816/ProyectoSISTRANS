package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Perecedero;
import uniandes.edu.co.proyecto.repositorio.PerecederoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PerecederoController {

    @Autowired 
    private PerecederoRepository perecederoRepository;

    @GetMapping("/Perecederos")
    public Collection<Perecedero> perecederos() {
        return perecederoRepository.darPerecederos();
    }   
    
    @PostMapping("/Perecederos/new/save")
    public ResponseEntity<String> perecederoGuardar(@RequestBody Perecedero perecedero) {
        try {
            perecederoRepository.insertarPerecedero(perecedero.getFechaVencimiento());
            return new ResponseEntity<>("Perecedero creado exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear el perecedero", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Perecederos/{id}/edit/save")
    public ResponseEntity<String> PerecederoEditarGuardar(@PathVariable("id") Integer id, @RequestBody Perecedero perecedero) {
        try {
            perecederoRepository.actualizarPerecedero(id, perecedero.getFechaVencimiento());
            return new ResponseEntity<>("Perecedero actualizado exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el perecedero", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/Perecederos/{id}/delete")
    public ResponseEntity<String> PerecederoEliminar(@PathVariable("id") Integer id) {
        try {
            perecederoRepository.eliminarPerecedero(id);
            return new ResponseEntity<>("Perecedero eliminado exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el perecedero", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
