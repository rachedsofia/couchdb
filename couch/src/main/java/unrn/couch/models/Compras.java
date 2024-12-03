package unrn.couch.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ektorp.support.CouchDbDocument;

@Builder
@Getter
@Data
@NoArgsConstructor
public class Compras extends CouchDbDocument {
    private String id_cliente;
    private String fechaDeCompra;

    public Compras(String id_cliente, String fechaDeCompra){
        this.id_cliente = id_cliente;
        this.fechaDeCompra = fechaDeCompra;
    }
}
