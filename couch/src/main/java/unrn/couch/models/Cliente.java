package unrn.couch.models;

import lombok.*;
import org.ektorp.support.CouchDbDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Getter
@Data
@NoArgsConstructor
@Document
public class Cliente extends CouchDbDocument {
     @Id
     private String idCliente;
     private String usuario;
     private String type;  // Campo para identificar el tipo de documento

     public Cliente(String idCliente, String usuario) {
          this.idCliente = idCliente;
          this.usuario = usuario;
          this.type = "cliente";  // Indicamos que es un documento de cliente
     }
}
