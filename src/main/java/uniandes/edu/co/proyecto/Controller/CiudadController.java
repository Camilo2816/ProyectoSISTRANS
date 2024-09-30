package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CiudadController {

    @Autowired 
    private CiudadRepository ciudadRepository;

    @GetMapping("/Ciudades")
    public Collection<Ciudad> ciudades() {
        return ciudadRepository.darCiudades();
    }
    
    @PostMapping("/Ciudades/new/save")
    public ResponseEntity<String> ciudadGuardar(@RequestBody Ciudad ciudad) {
        try {
            ciudadRepository.insertarCiudad(ciudad.getNombre());
            return new ResponseEntity<>("Ciudad creada exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Ciudades/{id}/edit/save")
    public ResponseEntity<String> ciudadEditarGuardar(@PathVariable("id") Integer id, @RequestBody Ciudad ciudad) {
        try {
            ciudadRepository.actualizarCiudad(id, ciudad.getNombre());
            return new ResponseEntity<>("Ciudad actualizada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Ciudades/{id}/delete")
    public ResponseEntity<String> ciudadEliminar(@PathVariable("id") Integer id) {
        try {
            ciudadRepository.eliminarCiudad(id);
            return new ResponseEntity<>("Ciudad eliminada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
