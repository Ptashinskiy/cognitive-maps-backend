package ptash.petr.cognitivemaps.service.api;

import org.megadix.jfcm.Concept;

public interface ConceptService {

    void addConcept(Concept concept, String mapName);

    void deleteConceptFromMap(String conceptName, String mapName);
}
