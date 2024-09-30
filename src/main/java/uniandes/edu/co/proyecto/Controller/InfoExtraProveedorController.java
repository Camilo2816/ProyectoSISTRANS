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
import uniandes.edu.co.proyecto.modelo.InfoExtraProveedor;
import uniandes.edu.co.proyecto.repositorio.InfoExtraProveedorRepository;


@RestController
public class InfoExtraProveedorController {

    @Autowired
    private InfoExtraProveedorRepository infoExtraProveedorRepository;

    @GetMapping("/infoExtraProveedores")
    public Collection<InfoExtraProveedor> infoExtraProveedores() {
        return infoExtraProveedorRepository.darInfoExtraProveedores();
    }
    
    @PostMapping("/infoExtraProveedores/new/save")
    public ResponseEntity<String> infoExtraProveedorGuardar(@RequestBody InfoExtraProveedor infoExtraProveedor) {

        try {
            infoExtraProveedorRepository.insertarInfoExtraProveedor(infoExtraProveedor.getPK().getProducto_id().getId(), infoExtraProveedor.getPK().getProveedor_id().getId(), infoExtraProveedor.getCantidadExistencias());
            return new ResponseEntity<>("InfoExtraProveedor creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al crear la infoExtraProveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/infoExtraProveedores/{id}/edit/save")
    public ResponseEntity<String> infoExtraProveedorEditarGuardar(@PathVariable("proveedorId") int proveedorId, @PathVariable("productoId") int productoId, @RequestBody InfoExtraProveedor infoExtraProveedor) {

        try {
            infoExtraProveedorRepository.updateInfoExtraProveedor(proveedorId, productoId, infoExtraProveedor.getCantidadExistencias());
            return new ResponseEntity<>("InfoExtraProveedor actualizada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al actualizar la infoExtraProveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/infoExtraProveedores/{id}/delete")
    public ResponseEntity<String> infoExtraProveedorEliminar(@PathVariable("proveedorId") int proveedorId, @PathVariable("proveedorId") int productoId ) {

        try {
            infoExtraProveedorRepository.eliminarInfoExtraProveedor(proveedorId, productoId);
            return new ResponseEntity<>("InfoExtraProveedor eliminada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al eliminar la infoExtraProveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
}
