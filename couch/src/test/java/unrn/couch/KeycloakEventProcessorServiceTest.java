package unrn.couch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import unrn.couch.exceptions.EventProcessingException;
import unrn.couch.models.Cliente;
import unrn.couch.repositories.ClienteRepository;
import unrn.couch.services.KeycloakEventProcessorService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class KeycloakEventProcessorServiceTest {
/*
    @Autowired
    private KeycloakEventProcessorService keycloakEventProcessorService;

    @Autowired
    private ClienteRepository clienteRepository;


    @Test
    void testProcessEventKeycloak() throws Exception {
        // Datos de prueba
        String eventMessage = """
            {
                "type": "REGISTER",
                "userId": "12345",
                "details": {
                    "username": "testUser"
                }
            }
        """;

        // Acción
        keycloakEventProcessorService.processEventKeycloak(eventMessage);

        // Verificación
        Optional<Cliente> clienteGuardado = clienteRepository.findById("12345");
        assertNotNull(clienteGuardado);
    }

    @Test
    void testProcessEventKeycloakInvalidJson() {
        // Datos de prueba
        String invalidMessage = "{ invalid json }";

        // Verificación de excepción
        EventProcessingException exception = assertThrows(EventProcessingException.class, () ->
                keycloakEventProcessorService.processEventKeycloak(invalidMessage));

        assertTrue(exception.getMessage().contains("Error al procesar el mensaje de Keycloak"));
    }*/
}
