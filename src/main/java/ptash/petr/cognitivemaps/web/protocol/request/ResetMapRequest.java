package ptash.petr.cognitivemaps.web.protocol.request;

import javax.validation.constraints.NotBlank;

public class ResetMapRequest {

    @NotBlank
    private String mapName;

    public ResetMapRequest() {
    }

    public ResetMapRequest(@NotBlank String mapName) {
        this.mapName = mapName;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
