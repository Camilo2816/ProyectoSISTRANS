package uniandes.edu.co.proyecto.Controller;
import java.math.BigDecimal;
//cambios
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository.ProductoRequiereOrdenProjection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class ProductoController {

    @Autowired 
    private ProductoRepository productoRepository;

    // Obtiene la lista de todos los productos.
    @GetMapping("/Productos")
    public Collection<Producto> productos() {
        return productoRepository.darProductos();
    }

    @GetMapping("/Productos/{id}")
    public ResponseEntity<?> producto(@PathVariable("id") Integer id) {
        
        Producto producto = productoRepository.darProducto(id);
        return ResponseEntity.ok(producto);
        
       
    }

    @PostMapping("/Productos/new/save")
    public ResponseEntity<String> productoGuardar(@RequestBody Producto producto) {
       
        productoRepository.insertarProducto(producto.getNombre(), producto.getCostoBodega(), producto.getPrecioUnitario(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getCodigoBarras(), producto.getFechaVencimiento(), producto.getCategoria_id().getId(), producto.getEspecificacionEmpaquetado_id().getId());
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);

       
    }

    // Actualiza un producto existente según su ID.
    @PutMapping("/Productos/{id}/edit/save")
    public ResponseEntity<String> productoEditarGuardar(@PathVariable("id") Integer id, @RequestBody Producto producto) {
    
        productoRepository.actualizarProducto(id, producto.getNombre(), producto.getCostoBodega(), producto.getPrecioUnitario(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getCodigoBarras(), producto.getFechaVencimiento(), producto.getCategoria_id().getId(), producto.getEspecificacionEmpaquetado_id().getId());
        return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
    
     
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



    @GetMapping("/buscar")
    public List<ProductoRepository.ProductoProjection> buscarProductos(
            @RequestParam(required = false) BigDecimal precioMin,
            @RequestParam(required = false) BigDecimal precioMax,
            @RequestParam(required = false) String fechaExpiracion,
            @RequestParam(required = false) Integer sucursalId,
            @RequestParam(required = false) Integer categoriaId) {

        return productoRepository.buscarProductos(precioMin, precioMax, fechaExpiracion, sucursalId, categoriaId);
    }

    
    @GetMapping("/productos/disponibles")
    public ResponseEntity<List<ProductoRepository.SucursalProjection>> obtenerSucursalesPorProducto(
            @RequestParam(required = false) Integer productoId,
            @RequestParam(required = false) String nombre) {
        
        List<ProductoRepository.SucursalProjection> sucursales = 
                productoRepository.encontrarSucursalesPorProducto(productoId, nombre);
        
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("/productos/requieren-orden")
    public List<ProductoRequiereOrdenProjection> obtenerProductosQueRequierenOrden() {
        return productoRepository.buscarProductosQueRequierenOrden();
    }
}
