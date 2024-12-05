package unrn.couch.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import unrn.couch.models.Cliente;

import java.util.List;

public interface ComprasContract {

    @PostMapping("/crearCliente")
    ResponseEntity<Cliente> crearCliente(@RequestBody Cliente ClienteRequest) ;

    @GetMapping("/{id}")
    ResponseEntity<Cliente> obtenerCliente(@PathVariable String id) ;

    @GetMapping("/listarClientes")
    ResponseEntity<List<Cliente>> listarClientes() ;

}
