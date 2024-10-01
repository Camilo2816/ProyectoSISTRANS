package uniandes.edu.co.proyecto.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository.RespuestaInformacionBodegas;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BodegasController {

    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/bodegas")
    public Collection<Bodega> bodegas() {
        return bodegaRepository.darBodegas();
    }

    @GetMapping("/bodegas/{id}")
    public ResponseEntity<?> bodega(@PathVariable("id") Integer id) {
        try {
            Bodega bodega = bodegaRepository.darBodega(id);
            return ResponseEntity.ok(bodega);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/bodegas/consulta")
    public ResponseEntity<?> bodegasConsulta(@RequestParam(required = false) Integer sucursal_id,
                                                @RequestParam(required = false) List<Integer> lista_procuctos){
    try {
        Collection<RespuestaInformacionBodegas> informacion = bodegaRepository.darInformacionBodegas();
        RespuestaInformacionBodegas info = informacion.iterator().next();
        Map<String, Object> response = new HashMap<>();
        response.put("nombreBodega", info.getNOMBRE_BODEGA());
        response.put("nombreSucursal", info.getNOMBRE_SUCURSAL());
        response.put("porcentajeOcupacion", info.getPORCENTAJE_OCUPACION());

        Collection<Bodega> bodegas;
        if ((sucursal_id == null ) || (lista_procuctos.isEmpty())){
        bodegas = bodegaRepository.darBodegas();
        } else {
            bodegas = bodegaRepository.darBodegasOcupacion(sucursal_id, lista_procuctos);
        }
        response.put("bodegas", bodegas);                                    
        return ResponseEntity.ok(response);
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
                                            }
    
    
    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> bodegaGuardar(@RequestBody Bodega bodega) {

        try {
            bodegaRepository.insertarBodega(bodega.getNombre(),bodega.getTamanio(), bodega.getCapacidad(), bodega.getSucursal().getId());
            return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/bodegas/{id}/edit/save")
    public ResponseEntity<String> bodegaEditarGuardar(@PathVariable("id") Integer id,  @RequestBody Bodega bodega) {

        try {
            bodegaRepository.actualizarBodega(id, bodega.getNombre(),bodega.getTamanio(), bodega.getCapacidad(), bodega.getSucursal().getId());
            return new ResponseEntity<>("Bodega actualizada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al actualizar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @DeleteMapping("/bodegas/{id}/delete")
    public ResponseEntity<String> bodegaEliminar(@PathVariable("id") Integer id) {

        try {
            bodegaRepository.eliminarBodega(id);
            return new ResponseEntity<>("Bodega eliminada correctamente", HttpStatus.OK);
        }
        catch (Exception e){
            return new  ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
