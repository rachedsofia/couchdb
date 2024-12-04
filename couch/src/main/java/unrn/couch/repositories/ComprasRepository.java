package unrn.couch.repositories;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.http.RestTemplate;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import unrn.couch.models.Compras;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Repository
public class ComprasRepository extends CouchDbRepositorySupport<Compras> {

    @Autowired
    public ComprasRepository(CouchDbConnector db) {
        super(Compras.class, db);
    }

    public List<Compras> obtenerComprasPorCliente(String idCliente) {
        ViewQuery query = new ViewQuery()
                .designDocId("_design/Compras")
                .viewName("by_id_cliente")
                .key(idCliente)
                .includeDocs(true);

        return db.queryView(query, Compras.class);
    }
    public List<Compras> obtenerUsuariosMasComprasUltimoMes() throws JsonProcessingException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date fechaLimite = cal.getTime();

        // Convertimos la fecha límite a formato ISO
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String fechaLimiteIso = sdf.format(fechaLimite);

        ViewQuery query = new ViewQuery()
                .designDocId("_design/Compras")
                .viewName("compras_por_cliente")
                .startKey(fechaLimiteIso)
                .includeDocs(true)
                .limit(2);

        ViewResult result = db.queryView(query);
        List<Compras> compras = new ArrayList<>();
        for (ViewResult.Row row : result.getRows()) {
            // Obtener el documento como JsonNode
            JsonNode jsonNode = row.getDocAsNode();

            // Convertir el JsonNode a objeto Compras
            ObjectMapper mapper = new ObjectMapper();
            Compras compra = mapper.treeToValue(jsonNode, Compras.class);

            compras.add(compra);
        }
        return compras;
    }



    public List<Compras> obtenerUltimasCompras() throws JsonProcessingException {
        ViewQuery query = new ViewQuery()
                .designDocId("_design/ultimasCompras")
                .viewName("ultimas_compras")
                .limit(3)
                .includeDocs(true);

        ViewResult result = db.queryView(query);
        List<Compras> compras = new ArrayList<>();
        for (ViewResult.Row row : result.getRows()) {
            // Obtener el documento como JsonNode
            JsonNode jsonNode = row.getDocAsNode();

            // Convertir el JsonNode a objeto Compras
            ObjectMapper mapper = new ObjectMapper();
            Compras compra = mapper.treeToValue(jsonNode, Compras.class);

            compras.add(compra);
        }
        return compras;
    }


}


