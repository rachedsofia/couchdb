package unrn.couch.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unrn.couch.exceptions.EventProcessingException;
import unrn.couch.models.Cliente;
import unrn.couch.models.events.RegisterEvent;
import unrn.couch.repositories.ClienteRepository;

@Service
public class KeycloakEventProcessorService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void processEventKeycloak(String message){
        try {
            ObjectMapper mapper = new ObjectMapper();
            RegisterEvent eventRegister = mapper.readValue(message, RegisterEvent.class);

            if(eventRegister.getType().equals("REGISTER")){

                Cliente cliente = new Cliente(eventRegister.getUserId(),
                        eventRegister.getDetails().getUsername());

                this.clienteRepository.add(cliente);
            }

        } catch (JsonProcessingException e) {
            throw new EventProcessingException("Error al procesar el mensaje de Keycloak: " + e.getMessage(), e);

        } catch (Exception e) {
            throw new EventProcessingException("Error al procesar el evento: " + e.getMessage(), e);
        }
    }
}

