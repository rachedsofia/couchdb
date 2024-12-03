package unrn.couch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unrn.couch.models.Compras;
import unrn.couch.repositories.ComprasRepository;

import java.util.List;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    public void registrarCompra(String idCliente, String fechaDeCompra) {
        Compras nuevaCompra = new Compras(idCliente, fechaDeCompra);
        comprasRepository.add(nuevaCompra);
    }

    public Compras obtenerCompraPorId(String id) {
        return comprasRepository.get(id);
    }

    public List<Compras> obtenerComprasPorCliente(String idCliente) {
        return comprasRepository.obtenerComprasPorCliente(idCliente);
    }

    public List<Compras> obtenerUsuariosMasComprasUltimoMes() {
        return comprasRepository.obtenerUsuariosMasComprasUltimoMes();
    }

    public List<Compras> obtenerUltimasCompras() {
        return comprasRepository.obtenerUltimasCompras();
    }
}

