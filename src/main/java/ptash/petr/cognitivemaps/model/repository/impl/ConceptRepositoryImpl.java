package ptash.petr.cognitivemaps.model.repository.impl;

import org.megadix.jfcm.Concept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ptash.petr.cognitivemaps.model.repository.api.CognitiveMapRepository;
import ptash.petr.cognitivemaps.model.repository.api.ConceptRepository;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConceptRepositoryImpl implements ConceptRepository {

    private Map<String, Concept> concepts = new HashMap<>();

    private final CognitiveMapRepository cognitiveMapRepository;

    @Autowired
    public ConceptRepositoryImpl(CognitiveMapRepository cognitiveMapRepository) {
        this.cognitiveMapRepository = cognitiveMapRepository;
    }

    @Override
    public void createNewConcept(Concept concept, String mapName) {

        this.concepts.put(concept.getName(), concept);
    }

    @Override
    public void deleteConcept(String conceptName) {

    }
}
