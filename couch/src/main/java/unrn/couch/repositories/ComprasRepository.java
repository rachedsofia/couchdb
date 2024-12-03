package unrn.couch.repositories;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.support.CouchDbRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unrn.couch.models.Compras;
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
    public List<Compras> obtenerUsuariosMasComprasUltimoMes() {
        ViewQuery query = new ViewQuery()
                .designDocId("_design/Compras\\n")
                .viewName("compras_ultimo_mes")
                .reduce(true)
                .group(true)
                .descending(true)
                .limit(2) // Limita a los dos usuarios con más compras
                .includeDocs(true);

        return db.queryView(query, Compras.class);
    }

    public List<Compras> obtenerUltimasCompras() {
        ViewQuery query = new ViewQuery()
                .designDocId("_design/Compras")
                .viewName("ultimas_compras")
                .descending(true)
                .limit(3) // Limita a 3 las últimas compras
                .includeDocs(true);

        return db.queryView(query, Compras.class);
    }

}
/*
    @Autowired
    private CouchDbConnector couchDbConnector;

    public void save(Compras compra) {
        couchDbConnector.create(compra);
    }

    public List<Compras> obtenerUltimasComprasPorCliente(String clienteId) {
        return couchDbConnector.queryView(
                new ViewQuery()
                        .designDocId("_design/ventas")
                        .viewName("ultimas_compras_por_cliente")
                        .key(clienteId)
                        .descending(true)
                        .limit(3),
                Compras.class
        );
    }

    public List<ClienteDTO> obtenerClientesConMasComprasUltimoMes() {
        List<ClienteDTO> clientes = couchDbConnector.queryView(
                new ViewQuery()
                        .designDocId("_design/ventas")
                        .viewName("clientes_con_mas_compras")
                        .group(true)
                        .reduce(true),
                ClienteDTO.class
        );
        return clientes.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getCantidadCompras(), c1.getCantidadCompras()))
                .limit(2)
                .toList();
    }
}


/*
@Repository
public class ComprasRepository {

    @Autowired
    private CouchDbConnector couchDbConnector;

        public List<Compras> obtenerUltimasComprasPorCliente(String clienteId) {
            List<Compras> compras = new ArrayList<>();
            try {
                ViewQuery query = new ViewQuery()
                        .designDocId("compras")
                        .viewName("by_id_cliente")
                        .key(clienteId)
                        .includeDocs(true)
                        .limit(3);

                ViewResult result = couchDbConnector.queryView(query);

                // Mapear los resultados de la vista
                for (ViewResult.Row row : result.getRows()) {
                    Compras compra = row.getDoc(Compras.class);
                    compras.add(compra);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error al obtener las últimas compras", e);
            }
            return compras;
        }

        public List<ClienteDTO> obtenerClientesConMasComprasUltimoMes() {
            List<ClienteDTO> clientes = new ArrayList<>();
            try {
                ViewQuery query = new ViewQuery()
                        .designDocId("compras")
                        .viewName("by_compras_ultimo_mes")
                        .reduce(true)
                        .group(true);

                ViewResult result = couchDbConnector.queryView(query);

                // Mapear los resultados de la vista
                for (ViewResult.Row row : result.getRows()) {
                    ClienteDTO clienteDTO = new ClienteDTO();
                    clienteDTO.setId(row.getKey());
                    clienteDTO.setCantidadCompras(Integer.parseInt(row.getValue()));
                    clientes.add(clienteDTO);
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error al obtener los clientes con más compras", e);
            }
            return clientes;
        }
    }
*/
