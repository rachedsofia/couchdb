package unrn.couch.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ektorp.support.CouchDbDocument;
import org.springframework.data.couchbase.core.mapping.Document;

@Getter
@Data
@NoArgsConstructor
@Document
public class Compras extends CouchDbDocument {

    private String id_cliente;
    private String fechaDeCompra;
    private String type;  // Campo para identificar el tipo de documento

    public Compras(String id_cliente, String fechaDeCompra){
        this.id_cliente = id_cliente;
        this.fechaDeCompra = fechaDeCompra;
        this.type = "compra";  // Indicamos que es un documento de compra
    }
}
