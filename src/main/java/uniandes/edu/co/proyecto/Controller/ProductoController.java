package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class ProductoController {

    @Autowired 
    private ProductoRepository productoRepository;

    // Obtiene la lista de todos los productos.
    @GetMapping("/Productos")
    public Collection<Producto> productos() {
        return productoRepository.darProductos();
    }

    // Guarda un nuevo producto en la base de datos.
    @PostMapping("/Productos/new/save")
    public ResponseEntity<String> productoGuardar(@RequestBody Producto producto) {
        try {
            productoRepository.insertarProducto(producto.getNombre(), producto.getCostoBodega(), producto.getPrecioUnitario(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getCodigoBarras(), producto.getFechaVencimiento(), producto.getCategoria_id(), producto.getEspecificacionEmpaquetado_id());
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualiza un producto existente según su ID.
    @PostMapping("/Productos/{id}/edit/save")
    public ResponseEntity<String> productoEditarGuardar(@PathVariable("id") Integer id, @RequestBody Producto producto) {
        try {
            productoRepository.actualizarProducto(id, producto.getNombre(), producto.getCostoBodega(), producto.getPrecioUnitario(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getCodigoBarras(), producto.getFechaVencimiento(), producto.getCategoria_id(), producto.getEspecificacionEmpaquetado_id());
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Elimina un producto de la base de datos según su ID.
    @GetMapping("/Productos/{id}/delete")
    public ResponseEntity<String> productoEliminar(@PathVariable("id") Integer id) {
        try {
            productoRepository.eliminarBar(id);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
