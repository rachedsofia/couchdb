package unrn.couch.models.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseEvent {
    private String idCliente;
    private String detalleCompra;

    public PurchaseEvent() {}

    public PurchaseEvent(String idCliente, String detalleCompra) {
        this.idCliente = idCliente;
        this.detalleCompra = detalleCompra;
    }
}
