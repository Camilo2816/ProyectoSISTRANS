package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.EspecificacionEmpaquetado;
import uniandes.edu.co.proyecto.repositorio.EspecificacionEmpaquetadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EspecificacionEmpaquetadoController {

    @Autowired 
    private EspecificacionEmpaquetadoRepository especificacionEmpaquetadoRepository;

    @GetMapping("/EspecificacionesEmpaquetado")
    public Collection<EspecificacionEmpaquetado> especificacionesEmpaquetado() {
        return especificacionEmpaquetadoRepository.darEspecificacionesEmpaquetado();
    }   
    
    @PostMapping("/EspecificacionesEmpaquetado/new/save")
    public ResponseEntity<String> especificacionEmpaquetadoGuardar(@RequestBody EspecificacionEmpaquetado especificacionEmpaquetado) {
        try {
            especificacionEmpaquetadoRepository.insertarEspecificacionEmpaquetado(especificacionEmpaquetado.getVolumen(), especificacionEmpaquetado.getPeso());
            return new ResponseEntity<>("Especificación de empaquetado creada exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear la especificación de empaquetado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/EspecificacionesEmpaquetado/{id}/edit/save")
    public ResponseEntity<String> especificacionEmpaquetadoEditarGuardar(@PathVariable("id") Integer id, @RequestBody EspecificacionEmpaquetado especificacionEmpaquetado) {
        try {
            especificacionEmpaquetadoRepository.actualizarEspecificacionEmpaquetado(id, especificacionEmpaquetado.getVolumen(), especificacionEmpaquetado.getPeso());
            return new ResponseEntity<>("Especificación de empaquetado actualizada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la especificación de empaquetado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/EspecificacionesEmpaquetado/{id}/delete")
    public ResponseEntity<String> especificacionEmpaquetadoEliminar(@PathVariable("id") Integer id) {
        try {
            especificacionEmpaquetadoRepository.eliminarEspecificacionEmpaquetado(id);
            return new ResponseEntity<>("Especificación de empaquetado eliminada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la especificación de empaquetado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
