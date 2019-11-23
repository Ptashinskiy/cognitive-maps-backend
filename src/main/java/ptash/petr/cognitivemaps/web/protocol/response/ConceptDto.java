package ptash.petr.cognitivemaps.web.protocol.response;

import org.megadix.jfcm.Concept;

public class ConceptDto {

    private String name;
    private String description;
    private double outputValue;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getOutputValue() {
        return outputValue;
    }

    private ConceptDto(String name, String description/*, double outputValue*/) {
        this.name = name;
        this.description = description;
        //this.outputValue = outputValue;
    }

    public static ConceptDto fromConcept(Concept concept) {
        return new ConceptDto(concept.getName(), concept.getDescription()/*, concept.getOutput()*/);
    }
}
