package ptash.petr.cognitivemaps.web;

import org.megadix.jfcm.Concept;
import org.megadix.jfcm.act.LinearActivator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptash.petr.cognitivemaps.common.CognitiveMapDto;
import ptash.petr.cognitivemaps.service.api.CognitiveMapService;
import ptash.petr.cognitivemaps.web.protocol.AddFlexibleConceptRequest;
import ptash.petr.cognitivemaps.web.protocol.AddHardConceptRequest;
import ptash.petr.cognitivemaps.web.protocol.CreateCognitiveMapRequest;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/maps")
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

    @GetMapping("/get/{name}")
    public ResponseEntity<CognitiveMapDto> getCognitiveMapByName(@PathVariable @Valid String name) {
        return ResponseEntity.ok(cognitiveMapService.getByName(name));
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
}
