package ptash.petr.cognitivemaps.model.repository.api;

import org.megadix.jfcm.Concept;

public interface ConceptRepository {

    void createNewConcept(Concept concept, String mapName);

    void deleteConcept(String conceptName);
}
