package ptash.petr.cognitivemaps.model.repository.impl;

import org.megadix.jfcm.CognitiveMap;
import org.springframework.stereotype.Component;
import ptash.petr.cognitivemaps.model.repository.api.CognitiveMapRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CognitiveMapRepositoryImpl implements CognitiveMapRepository {

    private Map<String, CognitiveMap> cognitiveMaps = new HashMap<>();

    public void save(CognitiveMap cognitiveMap) {
        this.cognitiveMaps.put(cognitiveMap.getName(), cognitiveMap);
    }

    @Override
    public List<CognitiveMap> getAll() {
        return new ArrayList<>(this.cognitiveMaps.values());
    }

    @Override
    public CognitiveMap getByName(String name) {
        return this.cognitiveMaps.get(name);
    }

    @Override
    public boolean existByName(String name) {
        return this.cognitiveMaps.containsKey(name);
    }

    public boolean notExistWithName(String name) {
        return !existByName(name);
    }
}
