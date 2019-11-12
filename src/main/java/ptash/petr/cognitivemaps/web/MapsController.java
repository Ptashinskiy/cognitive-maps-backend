package ptash.petr.cognitivemaps.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ptash.petr.cognitivemaps.service.MapsService;

@RestController("maps")
public class MapsController {

    private final MapsService mapsService;

    @Autowired
    public MapsController(MapsService mapsService) {
        this.mapsService = mapsService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewCognitiveMap(@RequestBody String name) {
        mapsService.createNewMap(name);
        return ResponseEntity.ok().build();
    }
}
