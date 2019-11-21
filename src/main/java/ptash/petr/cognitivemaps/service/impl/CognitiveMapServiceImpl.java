package ptash.petr.cognitivemaps.service.impl;

import org.megadix.jfcm.CognitiveMap;
import org.megadix.jfcm.Concept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptash.petr.cognitivemaps.model.repository.api.CognitiveMapRepository;
import ptash.petr.cognitivemaps.service.CognitiveMapException;
import ptash.petr.cognitivemaps.service.api.CognitiveMapService;

import java.util.Optional;

@Service
public class CognitiveMapServiceImpl implements CognitiveMapService {

    private static Logger log = LoggerFactory.getLogger(CognitiveMapServiceImpl.class);

    private final CognitiveMapRepository cognitiveMapRepository;

    @Autowired
    public CognitiveMapServiceImpl(CognitiveMapRepository cognitiveMapRepository) {
        this.cognitiveMapRepository = cognitiveMapRepository;
    }

    @Override
    public void createNewMap(String name) {
        if (cognitiveMapRepository.notExistWithName(name)) {
            cognitiveMapRepository.save(new CognitiveMap(name));
            log.info("Created new cognitive map with name {}", name);
        } else {
            log.error("Impossible to create cognitive map with name {}", name);
            throw CognitiveMapException.mapAlreadyExist(name);
        }
    }

    @Override
    public void addConcept(Concept concept, String mapName) {
        Optional<CognitiveMap> mapOptional = cognitiveMapRepository.getByName(mapName);
        if (mapOptional.isPresent()) {
            var cognitiveMap = mapOptional.get();
            cognitiveMap.addConcept(concept);
            cognitiveMapRepository.updateCognitiveMap(cognitiveMap);
        } else {
            log.error("Impossible to add concept to this cognitive map, map with name {} not exist", mapName);
            throw CognitiveMapException.mapNotExist(mapName);
        }
    }
}
