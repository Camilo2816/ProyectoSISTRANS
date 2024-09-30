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
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;

@RestController
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @GetMapping("/ordenCompras")
    public Collection<OrdenCompra> ordenCompras() {
        return ordenCompraRepository.darOrdenesCompra();
    }
    
    @PostMapping("/ordenCompras/new/save")
    public ResponseEntity<String> ordenCompraGuardar(@RequestBody OrdenCompra ordenCompra) {

        try {
            ordenCompraRepository.insertarOrdenCompra(ordenCompra.getCantidad(),ordenCompra.getPrecio(), ordenCompra.getFechaEntrega(), ordenCompra.getEstado());
            return new ResponseEntity<>("OrdenCompra creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al crear la ordenCompra", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/ordenCompras/{id}/edit/save")
    public ResponseEntity<String> ordenCompraEditarGuardar(@PathVariable("id") Integer id,  @RequestBody OrdenCompra ordenCompra) {

        try {
            ordenCompraRepository.actualizarOrdenCompra(id, ordenCompra.getCantidad(),ordenCompra.getPrecio(), ordenCompra.getFechaEntrega(), ordenCompra.getEstado());
            return new ResponseEntity<>("OrdenCompra actualizada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al actualizar la ordenCompra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/ordenCompras/{id}/delete")
    public ResponseEntity<String> ordenCompraEliminar(@PathVariable("id") Integer id) {

        try {
            ordenCompraRepository.eliminarOrdenCompra(id);
            return new ResponseEntity<>("OrdenCompra eliminada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al eliminar la ordenCompra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
}
