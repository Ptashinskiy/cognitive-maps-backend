package ptash.petr.cognitivemaps.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptash.petr.cognitivemaps.model.entites.MyCognitiveMap;

@Repository
public interface MapRepository extends JpaRepository<MyCognitiveMap, Long> {
}
