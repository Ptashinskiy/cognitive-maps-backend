package ptash.petr.cognitivemaps.web.protocol;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;

public class AddFlexibleConceptRequest {

    @NotBlank
    private String mapName;

    @NotBlank
    private String conceptName;

    @Nullable
    private String conceptDescription;

    public AddFlexibleConceptRequest() {
    }

    public AddFlexibleConceptRequest(String mapName, String conceptName, String conceptDescription) {
        this.mapName = mapName;
        this.conceptName = conceptName;
        this.conceptDescription = conceptDescription;
    }

    public String getMapName() {
        return mapName;
    }

    public String getConceptName() {
        return conceptName;
    }

    public String getConceptDescription() {
        return conceptDescription;
    }
}
