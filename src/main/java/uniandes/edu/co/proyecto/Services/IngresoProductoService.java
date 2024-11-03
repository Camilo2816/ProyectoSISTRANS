package uniandes.edu.co.proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.DetalleCostoBodega;
import uniandes.edu.co.proyecto.modelo.DetalleCostoBodegaPK;
import uniandes.edu.co.proyecto.modelo.DocumentoRecepcion;
import uniandes.edu.co.proyecto.modelo.InfoExtraBodega;
import uniandes.edu.co.proyecto.modelo.InfoExtraBodegaPK; // Asegúrate de importar esto
import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;
import uniandes.edu.co.proyecto.modelo.InfoExtraOrdenPK;
import uniandes.edu.co.proyecto.modelo.OrdenCompra;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.DetalleCostoBodegaRepository;
import uniandes.edu.co.proyecto.repositorio.DocumentoRecepcionRepository;
import uniandes.edu.co.proyecto.repositorio.InfoExtraBodegaRepository;
import uniandes.edu.co.proyecto.repositorio.InfoExtraOrdenRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenCompraRepository;

@Service
public class IngresoProductoService {

    @Autowired
    private DocumentoRecepcionRepository documentoRecepcionRepository;

    @Autowired
    private InfoExtraBodegaRepository infoExtraBodegaRepository;

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired
    private InfoExtraOrdenRepository infoExtraOrdenRepository;

    @Autowired
    private DetalleCostoBodegaRepository detalleCostoBodegaRepository;

    @Transactional
    public void registrarIngresoProductos(Integer bodegaId, Integer ordenCompraId) {
        try {
            System.out.println("Registrando ingreso de productos 1");
            DocumentoRecepcion documento = new DocumentoRecepcion();
            documento.setFechaEntregado(new Date());
            
            Bodega bodega = bodegaRepository.findById(bodegaId)
                .orElseThrow(() -> new EntityNotFoundException("Bodega no encontrada"));
            OrdenCompra ordenCompray = ordenCompraRepository.findById(ordenCompraId)
                .orElseThrow(() -> new EntityNotFoundException("Orden de Compra no encontrada"));
            documento.setIdBodega(bodega);
            documento.setOrdenCompra(ordenCompray);
    
            documentoRecepcionRepository.save(documento);
            System.out.println("Documento de recepción guardado.");
    
            System.out.println("Recuperando productos de la orden de compra...");
            System.out.println("ID de Orden de Compra: " + ordenCompraId);
            List<InfoExtraOrden> productosOrden = infoExtraOrdenRepository.findByPK_OrdenCompra(ordenCompray);   
            System.out.println("Productos recuperados de la orden: " + productosOrden.size());
    
            for (InfoExtraOrden producto : productosOrden) {
                System.out.println("Procesando producto: " + producto.getPK().getProducto_id());
                System.out.println("Cantidad: " + producto.getCantidad());
                System.out.println("Costo Unitario: " + producto.getCostoUnitario());
    
                // Actualizar inventario en InfoExtraBodega
                InfoExtraBodegaPK pk = new InfoExtraBodegaPK(bodegaRepository.findById(bodegaId)
                    .orElseThrow(() -> new EntityNotFoundException("Bodega no encontrada")),
                    producto.getPK().getProducto_id());
                
                InfoExtraBodega infoExtraBodega = infoExtraBodegaRepository
                    .findByPK(pk)
                    .orElseThrow(() -> new EntityNotFoundException("InfoExtraBodega no encontrada"));
                
                Long totalExistencias = infoExtraBodega.getTotalExistencias();
                BigDecimal costoPromedio = infoExtraBodega.getCostoPromedio();
                BigDecimal costoUnitario = producto.getCostoUnitario();
                BigDecimal cantidad = BigDecimal.valueOf(producto.getCantidad());
    
                // Calculate the new average cost
                System.out.println("Cálculo del nuevo costo promedio...");
                System.out.println("Costo Promedio Actual: " + costoPromedio);
                System.out.println("Total Existencias Antes: " + totalExistencias);
                System.out.println("Costo Unitario del Producto: " + costoUnitario);
                System.out.println("Cantidad del Producto: " + cantidad);
                
                BigDecimal nuevoCostoPromedio = 
                        (costoPromedio.multiply(BigDecimal.valueOf(totalExistencias))
                        .add(costoUnitario.multiply(cantidad)))
                        .divide(BigDecimal.valueOf(totalExistencias + producto.getCantidad()), RoundingMode.HALF_UP);
                
                System.out.println("Nuevo Costo Promedio Calculado: " + nuevoCostoPromedio);
                System.out.println("Total Existencias Después: " + (totalExistencias + producto.getCantidad()));
    
                infoExtraBodega.setTotalExistencias(totalExistencias + producto.getCantidad());
                infoExtraBodega.setCostoPromedio(nuevoCostoPromedio);
                infoExtraBodegaRepository.save(infoExtraBodega);
                System.out.println("Información actualizada guardada en InfoExtraBodega.");
    
                // Registrar detalle en DetalleCostoBodega
                DetalleCostoBodega detalle = new DetalleCostoBodega();
                detalle.setCostoUnitarioBod(producto.getCostoUnitario());
                detalle.setCantidadExistencias(producto.getCantidad());



            }
    
            // Cambiar estado de la OrdenCompra a ENTREGADA
            OrdenCompra ordenCompra = ordenCompraRepository.findById(ordenCompraId)
                .orElseThrow(() -> new EntityNotFoundException("Orden de Compra no encontrada"));
            ordenCompra.setEstado("ENTREGADA");
            ordenCompraRepository.save(ordenCompra);
            System.out.println("Estado de la Orden de Compra cambiado a ENTREGADA.");
        
        } catch (Exception e) {
            System.err.println("Error al registrar ingreso de productos: " + e.getMessage());
            e.printStackTrace(); // Esto te ayudará a entender qué error está ocurriendo
        }
    }
    
}
