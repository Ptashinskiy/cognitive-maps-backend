package ptash.petr.cognitivemaps.service.impl;

import org.megadix.jfcm.CognitiveMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptash.petr.cognitivemaps.model.repository.api.CognitiveMapRepository;
import ptash.petr.cognitivemaps.service.CognitiveMapException;
import ptash.petr.cognitivemaps.service.api.CognitiveMapService;

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
}
