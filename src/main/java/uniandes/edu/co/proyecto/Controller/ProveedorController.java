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
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;


@RestController
public class ProveedorController {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/proveedores")
    public Collection<Proveedor> proveedores() {
        return proveedorRepository.darProveedores();
    }
    
    @PostMapping("/proveedores/new/save")
    public ResponseEntity<String> proveedorGuardar(@RequestBody Proveedor proveedor) {

        try {
            proveedorRepository.insertarProveedor(proveedor.getNit(), proveedor.getNombre(),proveedor.getDireccion(), proveedor.getPersonaContacto(), proveedor.getTelefono());
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al crear al proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/proveedores/{id}/edit/save")
    public ResponseEntity<String> proveedorEditarGuardar(@PathVariable("id") Integer id,  @RequestBody Proveedor proveedor) {

        try {
            proveedorRepository.actualizarProveedor(id, proveedor.getNit(), proveedor.getNombre(),proveedor.getDireccion(), proveedor.getPersonaContacto(), proveedor.getTelefono());
            return new ResponseEntity<>("Proveedor actualizado correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al actualizar al proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/proveedores/{id}/delete")
    public ResponseEntity<String> proveedorEliminar(@PathVariable("id") Integer id) {

        try {
            proveedorRepository.eliminarProveedor(id);
            return new ResponseEntity<>("Proveedor eliminado correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al eliminar al proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}
