package ptash.petr.cognitivemaps.service.impl;

import org.megadix.jfcm.CognitiveMap;
import org.megadix.jfcm.Concept;
import org.megadix.jfcm.conn.WeightedConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptash.petr.cognitivemaps.common.CognitiveMapDto;
import ptash.petr.cognitivemaps.model.repository.api.CognitiveMapRepository;
import ptash.petr.cognitivemaps.model.exceptions.CognitiveMapException;
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

    @Override
    public CognitiveMapDto getByName(String name) {
        Optional<CognitiveMap> cognitiveMapOptional = cognitiveMapRepository.getByName(name);
        if (cognitiveMapOptional.isPresent()) {
            log.info("Returned cognitive map with name {}", name);
            CognitiveMap cognitiveMap = cognitiveMapOptional.get();
            cognitiveMap.execute();
            return CognitiveMapDto.fromCognitiveMap(cognitiveMap);
        } else {
            log.error("Cognitive map with name {} not found", name);
            throw CognitiveMapException.mapNotExist(name);
        }
    }

    @Override
    public void addConnection(WeightedConnection connection, String mapName, String fromConceptName, String toConceptName) {
        Optional<CognitiveMap> cognitiveMapOptional = cognitiveMapRepository.getByName(mapName);
        if (isAllExist(mapName, fromConceptName, toConceptName)) {
            CognitiveMap cognitiveMap = cognitiveMapOptional.get();
            cognitiveMap.addConnection(connection);
            cognitiveMap.connect(fromConceptName, connection.getName(), toConceptName);
        } else {
            log.error("Impossible to connect current concepts");
        }
    }

    private boolean conceptNotExistByName(String mapName, String conceptName) {
        Optional<CognitiveMap> cognitiveMapOptional = cognitiveMapRepository.getByName(mapName);
        return !cognitiveMapOptional.map(cognitiveMap -> cognitiveMap.getConcepts().containsKey(conceptName)).orElse(false);
    }

    private boolean isAllExist(String mapName, String firstConcept, String secondConcept) {
        Optional<CognitiveMap> cognitiveMapOptional = cognitiveMapRepository.getByName(mapName);
        if (cognitiveMapOptional.isEmpty()) {
            log.error("Impossible to obtain cognitive map with name {}", mapName);
            throw CognitiveMapException.mapNotExist(mapName);
        } else if (conceptNotExistByName(mapName, firstConcept)) {
            log.error("Impossible to obtain concept with name {}", firstConcept);
            throw CognitiveMapException.conceptNotExist(firstConcept);
        } else if (conceptNotExistByName(mapName, secondConcept)) {
            log.error("Impossible to obtain concept with name {}", secondConcept);
            throw CognitiveMapException.conceptNotExist(secondConcept);
        } else {
            return true;
        }
    }
}
