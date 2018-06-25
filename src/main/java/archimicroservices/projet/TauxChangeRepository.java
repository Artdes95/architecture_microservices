package archimicroservices.projet;
import org.springframework.data.jpa.repository.JpaRepository;


// Creation du JPA Repository basé sur Spring Data
public interface TauxChangeRepository extends JpaRepository<TauxChange, Long> {
    TauxChange findBySourceAndDest(String source, String dest);
}