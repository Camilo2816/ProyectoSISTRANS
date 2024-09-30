package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@RestController
public class SucursalController {
    
    @Autowired
    SucursalRepository sucursalRepository;

    @GetMapping("/sucursales")
    public Collection<Sucursal> sucursales() {
        return sucursalRepository.darSucursales();
    }
    
    @PostMapping("/sucursales/new/save")
    public ResponseEntity<String> sucursalGuardar(@RequestBody Sucursal sucursal) {

        try {
            sucursalRepository.insertarSucursal(sucursal.getNombre(),sucursal.getTamaño(), sucursal.getTelefono(), sucursal.getDireccion());
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al crear la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sucursales/{id}/edit/save")
    public ResponseEntity<String> sucursalEditarGuardar(@PathVariable("id") Integer id,  @RequestBody Sucursal sucursal) {

        try {
            sucursalRepository.actualizarSucursal(id, sucursal.getNombre(),sucursal.getTamaño(), sucursal.getTelefono(), sucursal.getDireccion());
            return new ResponseEntity<>("Sucursal actualizada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al actualizar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/sucursales/{id}/delete")
    public ResponseEntity<String> sucursalEliminar(@PathVariable("id") Integer id) {

        try {
            sucursalRepository.eliminarSucursal(id);
            return new ResponseEntity<>("Sucursal eliminada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al eliminar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
