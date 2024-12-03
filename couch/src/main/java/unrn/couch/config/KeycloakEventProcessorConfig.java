package unrn.couch.config;

import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import unrn.couch.services.KeycloakEventProcessorService;

@Configuration
public class KeycloakEventProcessorConfig {

    @Autowired
    private KeycloakEventProcessorService keycloakEventProcessorService;

    @Bean
    public Consumer<String> keycloakEventProcessor() {
        return message -> {
            this.keycloakEventProcessorService.processEventKeycloak(message);
        };

    }
}