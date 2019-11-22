package ptash.petr.cognitivemaps.web.protocol;

import javax.validation.constraints.NotBlank;

public class CreateCognitiveMapRequest {

    @NotBlank
    private String cognitiveMapName;

    public CreateCognitiveMapRequest() {
    }

    public CreateCognitiveMapRequest(String cognitiveMapName) {
        this.cognitiveMapName = cognitiveMapName;
    }

    public String getCognitiveMapName() {
        return cognitiveMapName;
    }

    public void setCognitiveMapName(String cognitiveMapName) {
        this.cognitiveMapName = cognitiveMapName;
    }
}
