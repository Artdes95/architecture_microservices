package services;
import metier.TauxChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// Creation du JPA Repository basé sur Spring Data
public interface TauxChangeRepository extends JpaRepository<TauxChange, Long> {

    List<TauxChange> findBySourceAndDest(String source, String dest);
    TauxChange findBySourceAndDestAndDateAndTaux(String source, String dest, String Date, double taux);

    TauxChange save(TauxChange tauxChange);
    void delete(TauxChange tauxChange);

    @Transactional
    @Modifying
    @Query("update TauxChange p set taux = ?4 where p.source = ?1 and p.dest = ?2 and p.date = ?3")
    int update(String source, String dest, String date, double taux);
}