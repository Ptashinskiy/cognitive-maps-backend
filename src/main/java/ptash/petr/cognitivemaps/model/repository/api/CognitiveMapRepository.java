package ptash.petr.cognitivemaps.model.repository.api;

import org.megadix.jfcm.CognitiveMap;

import java.util.List;
import java.util.Optional;

public interface CognitiveMapRepository {

    void save(CognitiveMap cognitiveMap);

    List<CognitiveMap> getAll();

    Optional<CognitiveMap> getByName(String name);

    boolean mapExistWithName(String name);

    boolean mapNotExistWithName(String name);

    boolean conceptExistInMap(String conceptName, String mapName);

    boolean conceptNotExistInMap(String conceptName, String mapName);

    boolean connectionExistInMap(String connectionName, String mapName);
}
