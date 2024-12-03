package unrn.couch.models.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteDTO {
    private String id;
    private String username;
    private int cantidadCompras;
}
