package ptash.petr.cognitivemaps.service.api;

import org.megadix.jfcm.Concept;
import ptash.petr.cognitivemaps.common.CognitiveMapDto;

public interface CognitiveMapService {

    void createNewMap(String name);

    void addConcept(Concept concept, String mapName);

    CognitiveMapDto getByName(String name);

}
