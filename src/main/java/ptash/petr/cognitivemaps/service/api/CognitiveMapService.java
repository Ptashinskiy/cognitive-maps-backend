package ptash.petr.cognitivemaps.service.api;

import org.megadix.jfcm.Concept;

public interface CognitiveMapService {

    void createNewMap(String name);

    void addConcept(Concept concept, String mapName);

}
