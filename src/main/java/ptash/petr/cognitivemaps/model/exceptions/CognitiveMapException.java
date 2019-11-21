package ptash.petr.cognitivemaps.model.exceptions;

public class CognitiveMapException extends RuntimeException {

    private CognitiveMapException(String message) {
        super(message);
    }

    public static CognitiveMapException mapAlreadyExist(String name) {
        return new CognitiveMapException("Cognitive map with name " + name + " already exist");
    }

    public static CognitiveMapException mapNotExist(String name) {
        return new CognitiveMapException("Cognitive map with name " + name + "not exist");
    }
}
