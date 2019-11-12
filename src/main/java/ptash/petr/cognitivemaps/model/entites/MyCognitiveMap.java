package ptash.petr.cognitivemaps.model.entites;

import org.megadix.jfcm.CognitiveMap;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MyCognitiveMap extends CognitiveMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public MyCognitiveMap() {}

    public MyCognitiveMap(String name) {
        super(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCognitiveMap myCognitiveMap1 = (MyCognitiveMap) o;
        return Objects.equals(id, myCognitiveMap1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                '}';
    }
}
