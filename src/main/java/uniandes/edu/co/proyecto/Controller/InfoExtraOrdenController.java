package uniandes.edu.co.proyecto.Controller;

//Esteban la cago JAJAJA 

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;

import uniandes.edu.co.proyecto.repositorio.InfoExtraOrdenRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class InfoExtraOrdenController {

    @Autowired 
    private InfoExtraOrdenRepository infoExtraOrdenRepository;

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/InfoExtraOrdenes")
    public Collection<InfoExtraOrden> infoExtraOrdenes() {
        return infoExtraOrdenRepository.darInfoExtraOrdenes();
    }   

    @PostMapping("/InfoExtraOrdenes/new/save")
    public ResponseEntity<String> infoExtraOrdenGuardar(@RequestBody InfoExtraOrden infoExtraOrden) {
        System.out.println("InfoExtraOrden: " + infoExtraOrden);

        if (infoExtraOrden == null || infoExtraOrden.getPK() == null) {
            return new ResponseEntity<>("Datos inválidos", HttpStatus.BAD_REQUEST);
        }

        // Continúa con la inserción en la base de datos utilizando los valores de PK
        infoExtraOrdenRepository.insertarInfoExtraOrden(
            infoExtraOrden.getPK().getOrdenCompra_id().getId(),
            infoExtraOrden.getPK().getProducto_id().getId(),
            infoExtraOrden.getCantidad(),
            infoExtraOrden.getCostoUnitario()
        );

    return new ResponseEntity<>("InfoExtraOrden creada exitosamente", HttpStatus.CREATED);
}

    

    
    
    

    @PostMapping("/InfoExtraOrdenes/{ordenId}/{productoId}/edit/save")
    public ResponseEntity<String> infoExtraOrdenEditarGuardar(@PathVariable("ordenId") Integer ordenId, @PathVariable("productoId") Integer productoId, @RequestBody InfoExtraOrden infoExtraOrden) {
        try {
            infoExtraOrdenRepository.actualizarInfoExtraOrden(ordenId, productoId, infoExtraOrden.getCantidad(), infoExtraOrden.getCostoUnitario()
            );
            return new ResponseEntity<>("InfoExtraOrden actualizada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la InfoExtraOrden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/InfoExtraOrdenes/{ordenId}/{productoId}/delete")
    public ResponseEntity<String> infoExtraOrdenEliminar(@PathVariable("ordenId") Integer ordenId, @PathVariable("productoId") Integer productoId) {
        try {
            infoExtraOrdenRepository.eliminarInfoExtraOrden(ordenId, productoId);
            return new ResponseEntity<>("InfoExtraOrden eliminada exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la InfoExtraOrden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
