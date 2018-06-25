package archimicroservices.projet;

import javax.annotation.*;
import javax.persistence.*;
import javax.persistence.Id;

@Entity

public class TauxChange {
    @Id
    @GeneratedValue
    private Long Id;
    String source;
    String dest;
    double taux;
    String date;


    public String affichage() {
        String aff=this.source + "/" + this.dest + " : " + String.valueOf(this.taux) + "(" + this.date +")";
        return aff;
    }
}
