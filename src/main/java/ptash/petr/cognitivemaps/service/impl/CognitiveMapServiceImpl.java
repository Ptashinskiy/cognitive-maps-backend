package ptash.petr.cognitivemaps.service.impl;

import org.megadix.jfcm.CognitiveMap;
import org.megadix.jfcm.Concept;
import org.megadix.jfcm.conn.WeightedConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptash.petr.cognitivemaps.model.common.CognitiveMapDto;
import ptash.petr.cognitivemaps.model.exceptions.CognitiveMapBadRequestException;
import ptash.petr.cognitivemaps.model.repository.api.CognitiveMapRepository;
import ptash.petr.cognitivemaps.model.exceptions.CognitiveMapNotFoundException;
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
        if (cognitiveMapRepository.mapNotExistWithName(name)) {
            cognitiveMapRepository.save(new CognitiveMap(name));
            log.info("Created new cognitive map with name {}", name);
        } else {
            log.error("Impossible to create cognitive map with name {}", name);
            throw CognitiveMapBadRequestException.mapAlreadyExist(name);
        }
    }

    @Override
    public void addConcept(Concept concept, String mapName) {
        String conceptName = concept.getName();
        if (cognitiveMapRepository.mapNotExistWithName(mapName)) {
            log.error("Impossible to add concept to this cognitive map, map with name {} not exist", mapName);
            throw CognitiveMapNotFoundException.mapNotExist(mapName);
        } else if (cognitiveMapRepository.conceptExistInMap(conceptName, mapName)) {
            log.error("Impossible to add this concept to cognitive map, concept with name {} already exist", conceptName);
            throw CognitiveMapBadRequestException.conceptAlreadyExist(conceptName);
        } else {
            cognitiveMapRepository.getByName(mapName).ifPresent(map -> map.addConcept(concept));
            log.info("Concept {} was added to cognitive map {}", conceptName, mapName);
        }
    }

    @Override
    public void addConnection(WeightedConnection connection, String mapName, String fromConceptName, String toConceptName) {
        String connectionName = connection.getName();
        if (cognitiveMapRepository.mapNotExistWithName(mapName)) {
            log.error("Impossible to add connection {}, cognitive map with name {} not found", connectionName, mapName);
            throw CognitiveMapNotFoundException.mapNotExist(mapName);
        } else if (cognitiveMapRepository.connectionExistInMap(connectionName, mapName)) {
            log.error("Impossible to add this connection, connection with name {} already exist", connectionName);
            throw CognitiveMapBadRequestException.connectionAlreadyExist(connectionName);
        } else if (cognitiveMapRepository.conceptNotExistInMap(fromConceptName, mapName)) {
            log.error("Impossible to add connection {}, concept with name {} not found", connectionName, fromConceptName);
            throw CognitiveMapNotFoundException.conceptNotExist(fromConceptName);
        } else if (cognitiveMapRepository.conceptNotExistInMap(toConceptName, mapName)) {
            log.error("Impossible to add connection {}, concept with name {} not found", connectionName, toConceptName);
            throw CognitiveMapNotFoundException.conceptNotExist(toConceptName);
        } else {
            cognitiveMapRepository.getByName(mapName).ifPresent(map -> {
                map.addConnection(connection);
                map.connect(fromConceptName, connection.getName(), toConceptName);
            });
            log.info("Added connection {} to map {}, from concept {} to concept {} with weight {}",
                    connectionName, mapName, fromConceptName, toConceptName, connection.getWeight());
        }
    }

    @Override
    public CognitiveMapDto getByName(String name) {
        Optional<CognitiveMap> cognitiveMapOptional = cognitiveMapRepository.getByName(name);
        if (cognitiveMapOptional.isPresent()) {
            CognitiveMap cognitiveMap = cognitiveMapOptional.get();
            return CognitiveMapDto.fromCognitiveMap(cognitiveMap);
        } else {
            log.error("Cognitive map with name {} not found", name);
            throw CognitiveMapNotFoundException.mapNotExist(name);
        }
    }

    @Override
    public CognitiveMapDto execute(String name) {
        Optional<CognitiveMap> cognitiveMapOptional = cognitiveMapRepository.getByName(name);
        CognitiveMap cognitiveMap = cognitiveMapOptional.orElseThrow(() -> CognitiveMapNotFoundException.mapNotExist(name));
        try {
            cognitiveMap.execute();
            log.info("Cognitive map with name {} executed", name);
            return CognitiveMapDto.fromCognitiveMap(cognitiveMap);
        } catch (Exception e) {
            log.error("Impossible to execute map with name {}, you may have a flexible concepts without any connection", name);
            throw CognitiveMapBadRequestException.cantExecuteMap(name);
        }
    }
}
