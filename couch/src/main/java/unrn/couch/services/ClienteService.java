package unrn.couch.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import unrn.couch.models.Cliente;
import unrn.couch.repositories.ClienteRepository;

import java.util.List;
@Service
public class ClienteService {
        @Autowired
        private ClienteRepository clienteRepository;

        public Cliente guardarCliente(String idCliente, String usuario) {
            Cliente cliente = new Cliente(idCliente,usuario);
            clienteRepository.add(cliente);
            return cliente;
        }

        public Cliente obtenerClientePorId(String id) {
            return clienteRepository.get(id);
        }

        public List<Cliente> obtenerTodosLosClientes() {
            return clienteRepository.getAll();
        }

    public List<Cliente> obtenerClientes() throws JsonProcessingException {
            return clienteRepository.obtenerClientes();
    }
}


