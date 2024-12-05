package unrn.couch.models;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.ektorp.support.CouchDbDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;


@Getter
@Data
@NoArgsConstructor
@Document

@JsonIgnoreProperties(ignoreUnknown = true)

public class Cliente extends CouchDbDocument {
     @Id
     private String idCliente;
     private String usuario;
     private String type = "cliente";

  /*   @JsonProperty("_id")
     private String id;

     @JsonProperty("_rev")
     private String rev;
*/
    public Cliente(String idCliente, String usuario) {
          this.idCliente = idCliente;
          this.usuario = usuario;
          this.type = "cliente";
     }
}
