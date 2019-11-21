package ptash.petr.cognitivemaps.service;

public class CognitiveMapException extends RuntimeException {

    private CognitiveMapException(String message) {
        super(message);
    }

    public static CognitiveMapException mapAlreadyExist(String name) {
        return new CognitiveMapException("Cognitive map with name " + name + " already exist");
    }
}
