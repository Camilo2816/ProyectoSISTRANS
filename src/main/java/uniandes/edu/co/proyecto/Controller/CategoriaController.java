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
import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;
@RestController
public class CategoriaController {
    
    @Autowired
    CategoriaRepository categoriaRepository;

    // Método GET para obtener todas las categorías
    @GetMapping("/categorias")
    public Collection<Categoria> categorias() {
        return categoriaRepository.darCategorias();
    }

    @GetMapping("/categorias/{id}")
    public Categoria categoria(@PathVariable("id") Integer id) {
        return categoriaRepository.darCategoria(id);
    }


    
    // Método POST para crear una nueva categoría
    // @RequestBody se utiliza para mapear el cuerpo de la solicitud HTTP a un objeto Categoria
    @PostMapping("/categorias/new/save")
    public ResponseEntity<String> categoriaGuardar(@RequestBody Categoria categoria) {

        try {
            categoriaRepository.insertarCategoria(categoria.getNombre(),categoria.getDescripcion(), categoria.getCaracteristicasAlmacenamiento());
            return new ResponseEntity<>("Categoria creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al crear la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método POST para actualizar una categoría existente basada en su ID
    @PostMapping("/categorias/{id}/edit/save")
    public ResponseEntity<String> categoriaEditarGuardar(@PathVariable("id") Integer id,  @RequestBody Categoria categoria) {

        try {
            categoriaRepository.actualizarCategoria(id, categoria.getNombre(),categoria.getDescripcion(), categoria.getCaracteristicasAlmacenamiento());
            return new ResponseEntity<>("Categoria actualizada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al actualizar la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método GET para eliminar una categoría por ID
    // No se recomienda el uso de GET para eliminar recursos, usualmente se usa DELETE.
    @GetMapping("/categorias/{id}/delete")
    public ResponseEntity<String> categoriaEliminar(@PathVariable("id") Integer id) {

        try {
            categoriaRepository.eliminarCategoria(id);
            return new ResponseEntity<>("Categoria eliminada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al eliminar la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
