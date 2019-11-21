package ptash.petr.cognitivemaps.web;

import org.megadix.jfcm.Concept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptash.petr.cognitivemaps.service.api.CognitiveMapService;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class CognitiveMapsController {

    private final CognitiveMapService cognitiveMapService;

    @Autowired
    public CognitiveMapsController(CognitiveMapService cognitiveMapService) {
        this.cognitiveMapService = cognitiveMapService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewCognitiveMap(@RequestBody String name) {
        cognitiveMapService.createNewMap(name);
        return ResponseEntity.ok().build();
    }
}
