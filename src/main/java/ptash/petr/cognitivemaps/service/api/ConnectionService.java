package ptash.petr.cognitivemaps.service.api;

import org.megadix.jfcm.conn.WeightedConnection;

public interface ConnectionService {

    void addConnection(WeightedConnection connection, String mapName, String fromConceptName, String toConceptName);

    void deleteConnectionFromMap(String connectionName, String mapName);

}
