package unrn.couch.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unrn.couch.models.Compras;
import unrn.couch.repositories.ComprasRepository;

import java.util.List;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    public Compras registrarCompra(String idCliente, String fechaDeCompra) {
        Compras nuevaCompra = new Compras(idCliente, fechaDeCompra);
        comprasRepository.add(nuevaCompra);
        return nuevaCompra;
    }

    public Compras obtenerCompraPorId(String id) {
        return comprasRepository.get(id);
    }
/*
    public List<Compras> obtenerComprasPorCliente(String idCliente) {
        return comprasRepository.obtenerComprasPorCliente(idCliente);
    }*/

    public List<Compras> obtenerUsuariosMasComprasUltimoMes()throws JsonProcessingException {
        return comprasRepository.obtenerUsuariosMasComprasUltimoMes();
    }

    public List<Compras> obtenerUltimasCompras() throws JsonProcessingException {
        return comprasRepository.obtenerUltimasCompras() ;
    }
}

