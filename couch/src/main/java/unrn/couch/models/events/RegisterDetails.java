package unrn.couch.models.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterDetails {

    private String email;
    private String username;
}
