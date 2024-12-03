package unrn.couch.models;

import lombok.*;
import org.ektorp.support.CouchDbDocument;

@Builder
@Getter
@Data
@NoArgsConstructor
public class Cliente extends CouchDbDocument {
     private String idCliente;
     private String usuario;

     public Cliente(String idCliente, String usuario) {
          this.idCliente = idCliente;
          this.usuario = usuario;
     }
}
