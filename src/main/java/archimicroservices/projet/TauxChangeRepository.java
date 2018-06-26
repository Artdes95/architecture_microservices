package archimicroservices.projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.NamedQuery;


// Creation du JPA Repository basé sur Spring Data
public interface TauxChangeRepository extends JpaRepository<TauxChange, Long> {

    //@Query("select u from TauxChange u where u.source = ?1 and u.dest= ?2")
    TauxChange findBySourceAndDest(String source, String dest);


}