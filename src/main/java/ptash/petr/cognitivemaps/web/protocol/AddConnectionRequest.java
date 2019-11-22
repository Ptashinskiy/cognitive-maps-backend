package ptash.petr.cognitivemaps.web.protocol;

import org.springframework.lang.Nullable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

public class AddConnectionRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String mapName;

    @NotBlank
    private String fromConceptName;

    @Nullable
    private String description;

    @NotBlank
    private String toConceptName;

    @DecimalMax(value = "1.0")
    @DecimalMin(value = "-1.0")
    private Double weight;

    public AddConnectionRequest() {
    }

    public AddConnectionRequest(@NotBlank String name, @NotBlank String mapName, @NotBlank String fromConceptName, @Nullable String description,
                                @NotBlank String toConceptName, @DecimalMax(value = "1.0") @DecimalMin(value = "-1.0") Double weight) {
        this.name = name;
        this.mapName = mapName;
        this.fromConceptName = fromConceptName;
        this.description = description;
        this.toConceptName = toConceptName;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setFromConceptName(String fromConceptName) {
        this.fromConceptName = fromConceptName;
    }

    public void setToConceptName(String toConceptName) {
        this.toConceptName = toConceptName;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMapName() {
        return mapName;
    }

    public String getFromConceptName() {
        return fromConceptName;
    }

    public String getToConceptName() {
        return toConceptName;
    }

    public Double getWeight() {
        return weight;
    }
}