package archimicroservices.projet;

import javax.persistence.*;
import javax.persistence.Id;

@Entity

public class TauxChange {
    @Id
    Long Id;
    String ccysource;
    String ccydestination;
    double taux;
    String date;




}
