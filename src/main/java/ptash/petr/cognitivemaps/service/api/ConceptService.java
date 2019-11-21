package ptash.petr.cognitivemaps.service.api;

import org.megadix.jfcm.Concept;

public interface ConceptService {

    void addNewConcept(Concept concept, String mapName);

    void makeFixedOutputForConcept(String conceptName, String mapName);
}
