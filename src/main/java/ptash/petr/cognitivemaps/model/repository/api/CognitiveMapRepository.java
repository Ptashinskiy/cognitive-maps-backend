package ptash.petr.cognitivemaps.model.repository.api;

import org.megadix.jfcm.CognitiveMap;

import java.util.List;
import java.util.Optional;

public interface CognitiveMapRepository {

    void save(CognitiveMap cognitiveMap);

    List<CognitiveMap> getAll();

    Optional<CognitiveMap> getByName(String name);

    boolean existByName(String name);

    boolean notExistWithName(String name);

    void updateCognitiveMap(CognitiveMap cognitiveMap);
}
