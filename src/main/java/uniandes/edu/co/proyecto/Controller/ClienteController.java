package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;

@RestController
public class ClienteController {

    @Autowired 
    private ClienteRepository clienteRepository;

    @GetMapping("/Clientes")
    public Collection<Cliente> clientes() {
        return clienteRepository.darClientes();
    }   
    
    @PostMapping("/Clientes/new/save")
    public ResponseEntity<String> clienteGuardar(@RequestBody Cliente cliente) {
        try {
            clienteRepository.insertarCliente(cliente.getNombre(), cliente.getCedula());
            return new ResponseEntity<>("Cliente creado exitosamente", HttpStatus.CREATED);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error al crear el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Clientes/{id}/edit/save")
    public ResponseEntity<String> clienteEditarGuardar(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        try {
            clienteRepository.actualizarCliente(id, cliente.getNombre(), cliente.getCedula());
            return new ResponseEntity<>("Cliente actualizado exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/Clientes/{id}/delete")
    public ResponseEntity<String> clienteEliminar(@PathVariable("id") Integer id) {
        try {
            clienteRepository.eliminarCliente(id);
            return new ResponseEntity<>("Cliente eliminado exitosamente", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
