package unrn.couch.models.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterEvent {

    private String type;
    private String userId;
    private RegisterDetails details;
}
