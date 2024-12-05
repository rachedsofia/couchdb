package unrn.couch.repositories;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import unrn.couch.models.Cliente;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository extends CouchDbRepositorySupport<Cliente> {
    @Autowired
    private CouchDbConnector couchDbConnector;

    @Autowired
    public ClienteRepository(CouchDbConnector db) {
        super(Cliente.class, db);
    }

    public List<Cliente> obtenerClientes() throws JsonProcessingException {
        ViewQuery query = new ViewQuery().designDocId("_design/Clientes")
                .viewName("todos_clientes");

        ViewResult result = db.queryView(query);
        List<Cliente> clientes = new ArrayList<>();
        for (ViewResult.Row row : result.getRows()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(result.toString());
            Cliente cliente = mapper.treeToValue(root, Cliente.class);
            clientes.add(cliente);
        }
        return clientes;
    }
    public List<Cliente> todosLosDocs(){
        ViewQuery vw = new ViewQuery().allDocs();
        return db.queryView(vw.designDocId("_design/Clientes").viewName("todos_clientes"),Cliente.class);
    }
}
