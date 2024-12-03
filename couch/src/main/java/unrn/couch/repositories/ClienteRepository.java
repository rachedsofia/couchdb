package unrn.couch.repositories;
import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import unrn.couch.models.Cliente;

@Repository
public class ClienteRepository extends CouchDbRepositorySupport<Cliente> {
    @Autowired
    private CouchDbConnector couchDbConnector;
    @Autowired
    public ClienteRepository(CouchDbConnector db) {
        super(Cliente.class, db);
    }
}
