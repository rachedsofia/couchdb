package unrn.couch.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unrn.couch.exceptions.EventProcessingException;
import unrn.couch.models.Compras;
import unrn.couch.models.events.PurchaseEvent;
import unrn.couch.repositories.ClienteRepository;
import unrn.couch.repositories.ComprasRepository;

@Service
public class PurchaseEventProcessorService {

    @Autowired
    private ComprasRepository comprasRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    public void processEventPurchase(PurchaseEvent purchaseEvent){
        try {
            String detalleCompra = purchaseEvent.getDetalleCompra();
            String fechaCompra = detalleCompra.split(",")[0].split(":")[1].trim();
            System.out.printf(fechaCompra);

            comprasRepository.add(Compras.builder()
                    .id_cliente(purchaseEvent.getIdCliente())
                    .fechaDeCompra(fechaCompra)
                    .build());

        } catch (Exception e){
            throw new EventProcessingException("Error al procesar el evento: " + e.getMessage(), e);
        }
    }
}

