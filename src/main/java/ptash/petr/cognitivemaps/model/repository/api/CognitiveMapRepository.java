package ptash.petr.cognitivemaps.model.repository.api;

import org.megadix.jfcm.CognitiveMap;

import java.util.List;

public interface CognitiveMapRepository {

    void save(CognitiveMap cognitiveMap);

    List<CognitiveMap> getAll();

    CognitiveMap getByName(String name);

    boolean existByName(String name);

    boolean notExistWithName(String name);
}