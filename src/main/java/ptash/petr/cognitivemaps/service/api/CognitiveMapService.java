package ptash.petr.cognitivemaps.service.api;

import org.megadix.jfcm.Concept;
import org.megadix.jfcm.conn.WeightedConnection;
import ptash.petr.cognitivemaps.model.common.CognitiveMapDto;

public interface CognitiveMapService {

    void createNewMap(String name);

    void addConcept(Concept concept, String mapName);

    CognitiveMapDto getByName(String name);

    void addConnection(WeightedConnection connection, String mapName, String fromConceptName, String toConceptName);

    CognitiveMapDto execute(String name);
}
