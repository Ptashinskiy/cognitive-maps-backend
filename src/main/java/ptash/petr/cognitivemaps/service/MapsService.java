package ptash.petr.cognitivemaps.service;

import ptash.petr.cognitivemaps.model.entites.MyCognitiveMap;

import java.util.List;

public interface MapsService {

    void createNewMap(String name);

    List<MyCognitiveMap> getAllCognitiveMaps();
}
