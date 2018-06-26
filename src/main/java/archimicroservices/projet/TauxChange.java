package archimicroservices.projet;

import javax.annotation.*;
import javax.persistence.*;

@Entity

public class TauxChange {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String source;
    private String dest;
    private double taux;
    private String date;

    protected TauxChange(){}

    public TauxChange(String source, String dest, double taux, String date){
        this.source = source;
        this.dest = dest;
        this.taux = taux;
        this.date = date;
    }

    public TauxChange(Long id, String source, String dest, double taux, String date) {
        this.id = id;
        this.source = source;
        this.dest = dest;
        this.taux = taux;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(
                "Rate : id=%d, '%s'/'%s'= %f ('%s')",
                id, source, dest, taux, date);
    }


    public String affichage() {
        String aff=this.source + "/" + this.dest + " : " + String.valueOf(this.taux) + "(" + this.date +")";
        return aff;
    }
}
