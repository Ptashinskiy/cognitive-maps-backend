package ptash.petr.cognitivemaps.web.protocol.request;

public class DeleteConnectionRequest {

    private String connectionName;
    private String mapName;

    public DeleteConnectionRequest() {}

    public DeleteConnectionRequest(String connectionName, String mapName) {
        this.connectionName = connectionName;
        this.mapName = mapName;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
