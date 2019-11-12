package ptash.petr.cognitivemaps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptash.petr.cognitivemaps.model.entites.MyCognitiveMap;
import ptash.petr.cognitivemaps.model.repository.MapRepository;

import java.util.List;

@Service
public class MapsServiceImpl implements MapsService {

    private final MapRepository mapRepository;

    @Autowired
    public MapsServiceImpl(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public void createNewMap(String name) {
        var map = new MyCognitiveMap();
        mapRepository.save(map);
    }

    @Override
    public List<MyCognitiveMap> getAllCognitiveMaps() {
        return mapRepository.findAll();
    }
}
