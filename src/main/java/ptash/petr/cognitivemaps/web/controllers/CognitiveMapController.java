package ptash.petr.cognitivemaps.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptash.petr.cognitivemaps.web.protocol.response.CognitiveMapDto;
import ptash.petr.cognitivemaps.service.api.CognitiveMapService;
import ptash.petr.cognitivemaps.web.protocol.request.CreateCognitiveMapRequest;
import ptash.petr.cognitivemaps.web.protocol.request.DeleteMapRequest;
import ptash.petr.cognitivemaps.web.protocol.request.GetMapRequest;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/map")
public class CognitiveMapController {

    private final CognitiveMapService cognitiveMapService;

    @Autowired
    public CognitiveMapController(CognitiveMapService cognitiveMapService) {
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

    @GetMapping("/getAll")
    public ResponseEntity<List<CognitiveMapDto>> getAllCognitiveMaps() {
        return ResponseEntity.ok(cognitiveMapService.getAll());
    }

    @GetMapping("/execute")
    public ResponseEntity<CognitiveMapDto> executeMap(@RequestBody @Valid GetMapRequest request) {
        return ResponseEntity.ok(cognitiveMapService.execute(request.getName()));
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteMap(@RequestBody @Valid DeleteMapRequest request) {
        cognitiveMapService.deleteCognitiveMap(request.getMapName());
        return ResponseEntity.ok().build();
    }
}
