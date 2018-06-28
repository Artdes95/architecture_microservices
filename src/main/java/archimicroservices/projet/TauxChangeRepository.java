package archimicroservices.projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// Creation du JPA Repository basé sur Spring Data
public interface TauxChangeRepository extends JpaRepository<TauxChange, Long> {

    List<TauxChange> findBySourceAndDest(String source, String dest);

    @Query("select u.taux from TauxChange u where u.source=?1 and u.dest=?2 and u.date=?3 ")
    double findBySourceAndDestAndDate(String source, String dest, String date);
}