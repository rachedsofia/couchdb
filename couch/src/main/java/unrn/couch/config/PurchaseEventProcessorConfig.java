package unrn.couch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import unrn.couch.models.events.PurchaseEvent;
import unrn.couch.services.PurchaseEventProcessorService;

import java.util.function.Consumer;

@Configuration
public class PurchaseEventProcessorConfig {

    @Autowired
    private PurchaseEventProcessorService purchaseEventProcessorService;

    @Bean
    public Consumer<PurchaseEvent> purchaseEventProcessor() {
        return purchaseEvent -> {
            this.purchaseEventProcessorService.processEventPurchase(purchaseEvent);
        };
    }
}
