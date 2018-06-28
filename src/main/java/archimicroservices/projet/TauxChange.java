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

    public TauxChange(){}

    public TauxChange(String source, String dest, double taux, String date){
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
