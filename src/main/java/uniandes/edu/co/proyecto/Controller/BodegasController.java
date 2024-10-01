package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BodegasController {

    // Inyección automática del repositorio que gestiona las bodegas
    @Autowired
    private BodegaRepository bodegaRepository;

    /**
     * Método GET para obtener la lista de todas las bodegas.
     * 
     * @return Devuelve una colección de objetos de tipo Bodega
     *         obtenidos a través del método darBodegas del repositorio.
     */
    @GetMapping("/bodegas")
    public Collection<Bodega> bodegas() {
        // Retorna la lista de todas las bodegas desde el repositorio
        return bodegaRepository.darBodegas();
    }
    
    /**
     * Método POST para guardar una nueva bodega en la base de datos.
     * 
     * @param bodega Objeto de tipo Bodega recibido en el cuerpo de la petición.
     * @return ResponseEntity con un mensaje indicando el resultado de la operación.
     *         Si la bodega se guarda correctamente, devuelve un estado HTTP 201 (CREATED).
     *         Si hay un error, devuelve un estado HTTP 500 (INTERNAL_SERVER_ERROR).
     */
    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> bodegaGuardar(@RequestBody Bodega bodega) {

        try {
            // Llamada al repositorio para insertar una nueva bodega con sus atributos
            bodegaRepository.insertarBodega(
                bodega.getNombre(),
                bodega.getTamanio(),
                bodega.getCapacidad(),
                bodega.getSucursal().getId()
            );
            return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e) {
            // En caso de excepción, se devuelve un mensaje de error
            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Método POST para actualizar una bodega existente.
     * 
     * @param id Identificador de la bodega que se va a actualizar, extraído de la URL.
     * @param bodega Objeto de tipo Bodega recibido en el cuerpo de la petición con los datos actualizados.
     * @return ResponseEntity con un mensaje indicando el resultado de la operación.
     *         Si la bodega se actualiza correctamente, devuelve un estado HTTP 200 (OK).
     *         Si hay un error, devuelve un estado HTTP 500 (INTERNAL_SERVER_ERROR).
     */
    @PostMapping("/bodegas/{id}/edit/save")
    public ResponseEntity<String> bodegaEditarGuardar(@PathVariable("id") Integer id, @RequestBody Bodega bodega) {

        try {
            // Llamada al repositorio para actualizar los detalles de la bodega especificada por su ID
            bodegaRepository.actualizarBodega(
                id,
                bodega.getNombre(),
                bodega.getTamanio(),
                bodega.getCapacidad(),
                bodega.getSucursal().getId()
            );
            return new ResponseEntity<>("Bodega actualizada correctamente", HttpStatus.OK);
        }
        catch (Exception e) {
            // En caso de excepción, se devuelve un mensaje de error
            return new ResponseEntity<>("Error al actualizar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Método GET para eliminar una bodega por su identificador.
     * 
     * @param id Identificador de la bodega que se va a eliminar, extraído de la URL.
     * @return ResponseEntity con un mensaje indicando el resultado de la operación.
     *         Si la bodega se elimina correctamente, devuelve un estado HTTP 200 (OK).
     *         Si hay un error, devuelve un estado HTTP 500 (INTERNAL_SERVER_ERROR).
     */
    @GetMapping("/bodegas/{id}/delete")
    public ResponseEntity<String> bodegaEliminar(@PathVariable("id") Integer id) {

        try {
            // Llamada al repositorio para eliminar la bodega especificada por su ID
            bodegaRepository.eliminarBodega(id);
            return new ResponseEntity<>("Bodega eliminada correctamente", HttpStatus.OK);
        }
        catch (Exception e) {
            // En caso de excepción, se devuelve un mensaje de error
            return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
