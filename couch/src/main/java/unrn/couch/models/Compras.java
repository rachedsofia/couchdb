package unrn.couch.models;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

@JsonIgnoreProperties(ignoreUnknown = true)

public class Compras extends CouchDbDocument {

    private String id_cliente;
    private String fechaDeCompra;
    private String type = "compra";
    @JsonProperty("_id")
    private String id;

    @JsonProperty("_rev")
    private String rev;

    public Compras(String id_cliente, String fechaDeCompra){
        this.id_cliente = id_cliente;
        this.fechaDeCompra = fechaDeCompra;
    }
}
