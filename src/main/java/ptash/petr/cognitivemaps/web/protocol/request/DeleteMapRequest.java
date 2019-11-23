package ptash.petr.cognitivemaps.web.protocol.request;

import javax.validation.constraints.NotBlank;

public class DeleteMapRequest {

    @NotBlank
    private String mapName;

    public DeleteMapRequest() {}

    public DeleteMapRequest(@NotBlank String mapName) {
        this.mapName = mapName;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(@NotBlank String mapName) {
        this.mapName = mapName;
    }
}
