package ptash.petr.cognitivemaps.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptash.petr.cognitivemaps.service.api.CognitiveMapService;

@RestController
@RequestMapping("/maps")
public class MapsController {

    private final CognitiveMapService cognitiveMapService;

    @Autowired
    public MapsController(CognitiveMapService cognitiveMapService) {
        this.cognitiveMapService = cognitiveMapService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewCognitiveMap(@RequestBody String name) {
        cognitiveMapService.createNewMap(name);
        return ResponseEntity.ok().build();
    }
}
