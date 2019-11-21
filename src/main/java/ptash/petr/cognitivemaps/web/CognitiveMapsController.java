package ptash.petr.cognitivemaps.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ptash.petr.cognitivemaps.common.CognitiveMapDto;
import ptash.petr.cognitivemaps.service.api.CognitiveMapService;

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

    @GetMapping("/get")
    public ResponseEntity<CognitiveMapDto> getCognitiveMapByName(@RequestBody String name) {
        return ResponseEntity.ok(cognitiveMapService.getByName(name));
    }
}
