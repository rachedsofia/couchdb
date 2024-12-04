package unrn.couch.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unrn.couch.models.Cliente;
import unrn.couch.models.Compras;
import unrn.couch.services.ComprasService;
import unrn.couch.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController implements ComprasContract{

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ComprasService comprasService;

    @PostMapping("/crearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente ClienteRequest) {
        return ResponseEntity.ok(clienteService.guardarCliente(ClienteRequest.getIdCliente(), ClienteRequest.getUsuario()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable String id) {
        return ResponseEntity.ok(clienteService.obtenerClientePorId(id));
    }

    @GetMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.obtenerTodosLosClientes());
    }
    @GetMapping("/listarLosClientes")
    public ResponseEntity<List<Cliente>> listarLosClientes() throws JsonProcessingException {
        return ResponseEntity.ok(clienteService.obtenerClientes());
    }

    @PostMapping("/crear")
    public ResponseEntity<Compras> registrarCompra(@RequestBody Compras CompraRequest) {
         return  ResponseEntity.ok(comprasService.registrarCompra(CompraRequest.getId_cliente(), CompraRequest.getFechaDeCompra()));
    }

    @GetMapping("/obtenerCliente/{id}")
    public Compras obtenerCompraPorId(@PathVariable String id) {
         return comprasService.obtenerCompraPorId(id);
    }

    @GetMapping("/usuariosMasComprasUltimoMes")
    public List<Compras> obtenerUsuariosMasComprasUltimoMes()  throws JsonProcessingException{
        return comprasService.obtenerUsuariosMasComprasUltimoMes();
    }

    @GetMapping("/ultimasCompras")
    public List<Compras> obtenerUltimasCompras() throws JsonProcessingException {
        return comprasService.obtenerUltimasCompras();
    }


public class ClienteRequest {
    private String idCliente;
    private String usuario;

    // Getters y Setters
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}

public class CompraRequest{
    private String id_cliente;
    private String fechaDeCompra;

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(String fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }
}
}
