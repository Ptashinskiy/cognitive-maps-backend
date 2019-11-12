package ptash.petr.cognitivemaps.model.entites;

import org.megadix.jfcm.CognitiveMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class MyCognitiveMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private CognitiveMap cognitiveMap;

    public MyCognitiveMap() {
    }

    public MyCognitiveMap(CognitiveMap cognitiveMap) {
        this.cognitiveMap = cognitiveMap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CognitiveMap getCognitiveMap() {
        return cognitiveMap;
    }

    public void setCognitiveMap(CognitiveMap cognitiveMap) {
        this.cognitiveMap = cognitiveMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCognitiveMap myCognitiveMap1 = (MyCognitiveMap) o;
        return Objects.equals(id, myCognitiveMap1.id) &&
                Objects.equals(cognitiveMap, myCognitiveMap1.cognitiveMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cognitiveMap);
    }

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", map=" + cognitiveMap +
                '}';
    }
}
