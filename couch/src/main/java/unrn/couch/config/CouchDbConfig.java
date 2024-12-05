package unrn.couch.config;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchDbConfig {

    @Bean
    public CouchDbConnector couchDbConnector() {
        try {

            HttpClient httpClient = new StdHttpClient.Builder()
                    //.url("http://127.0.0.1:5984")
                    .host("localhost")
                    .port(5984)
                    .username("admin")           // Usuario
                    .password("admin")           // Contraseña
                    .build();

            CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
            return dbInstance.createConnector("compras", true); // Nombre de la base de datos
        } catch (Exception e) {
            throw new RuntimeException("Error configurando CouchDbConnector: " + e.getMessage(), e);
        }
    }
}
