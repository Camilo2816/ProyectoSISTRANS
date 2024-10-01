package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired 
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<Collection<Cliente>> obtenerClientes() {
        try {
            Collection<Cliente> clientes = clienteRepository.darClientes();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear un nuevo cliente
    @PostMapping("/new")
    public ResponseEntity<String> guardarCliente(@RequestBody Cliente cliente) {
        try {
            clienteRepository.insertarCliente(cliente.getNombre(), cliente.getCedula());
            return new ResponseEntity<>("Cliente creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}/edit")
    public ResponseEntity<String> editarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        try {
            clienteRepository.actualizarCliente(id, cliente.getNombre(), cliente.getCedula());
            return new ResponseEntity<>("Cliente actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Eliminar un cliente
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarCliente(@PathVariable("id") Integer id) {
        try {
            clienteRepository.eliminarCliente(id);
            return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
