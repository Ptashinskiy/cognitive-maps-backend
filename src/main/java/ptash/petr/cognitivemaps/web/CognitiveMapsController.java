package ptash.petr.cognitivemaps.web;

import org.megadix.jfcm.Concept;
import org.megadix.jfcm.act.LinearActivator;
import org.megadix.jfcm.conn.WeightedConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptash.petr.cognitivemaps.model.common.CognitiveMapDto;
import ptash.petr.cognitivemaps.service.api.CognitiveMapService;
import ptash.petr.cognitivemaps.web.protocol.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/map")
public class CognitiveMapsController {

    private final CognitiveMapService cognitiveMapService;

    @Autowired
    public CognitiveMapsController(CognitiveMapService cognitiveMapService) {
        this.cognitiveMapService = cognitiveMapService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewCognitiveMap(@RequestBody CreateCognitiveMapRequest request) {
        cognitiveMapService.createNewMap(request.getCognitiveMapName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get") //todo handle nullpointer
    public ResponseEntity<CognitiveMapDto> getCognitiveMapByName(@RequestBody @Valid GetMapRequest request) {
        return ResponseEntity.ok(cognitiveMapService.getByName(request.getName()));
    }

    @GetMapping("/execute")
    public ResponseEntity<CognitiveMapDto> executeMap(@RequestBody @Valid GetMapRequest request) {
        return ResponseEntity.ok(cognitiveMapService.execute(request.getName()));
    }

    @PostMapping("/addFlexConcept")
    public void addFlexibleConcept(@RequestBody @Valid AddFlexibleConceptRequest request) {
        Concept concept = new Concept(request.getConceptName(), request.getConceptDescription(), new LinearActivator(), 0.0, 0.0, false);
        cognitiveMapService.addConcept(concept, request.getMapName());
    }

    @PostMapping("/addHardConcept")
    public void addHardConcept(@RequestBody @Valid AddHardConceptRequest request) {
        Concept concept = new Concept(request.getConceptName(), request.getConceptDescription(),
                new LinearActivator(), 0.0, request.getOutputValue(), true);
        cognitiveMapService.addConcept(concept, request.getMapName());
    }

    /**Must be atomic operation, recode with try-catch*/
    @PostMapping("/addConnection")
    public void addConnection(@RequestBody @Valid AddConnectionRequest request) {
        WeightedConnection connection = new WeightedConnection(request.getConnectionName(), request.getDescription(), request.getWeight());
        cognitiveMapService.addConnection(connection, request.getMapName(), request.getFromConceptName(), request.getToConceptName());
    }
}
