package ptash.petr.cognitivemaps.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CognitiveMapException extends RuntimeException {

    private CognitiveMapException(String message) {
        super(message);
    }

    public static CognitiveMapException mapAlreadyExist(String name) {
        return new CognitiveMapException("Cognitive map with name " + name + " already exist");
    }

    public static CognitiveMapException mapNotExist(String name) {
        return new CognitiveMapException("Cognitive map with name " + name + " not exist");
    }

    public static CognitiveMapException conceptNotExist(String name) {
        return new CognitiveMapException("Concept with name " + name + " not exist");
    }

    public static CognitiveMapException conceptAlreadyExist(String name) {
        return new CognitiveMapException("Concept with name " + name + " already exist");
    }

    public static CognitiveMapException cantExecuteMap(String name) {
        return new CognitiveMapException("Impossible to execute map with name " + name);
    }

    public static CognitiveMapException connectionAlreadyExist(String name) {
        return new CognitiveMapException("Connection with name " + name + " already exist");
    }
}
