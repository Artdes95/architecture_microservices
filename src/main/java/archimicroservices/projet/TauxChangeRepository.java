package archimicroservices.projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// Creation du JPA Repository basé sur Spring Data
public interface TauxChangeRepository extends JpaRepository<TauxChange, Long> {

    List<TauxChange> findBySourceAndDest(String source, String dest);
}