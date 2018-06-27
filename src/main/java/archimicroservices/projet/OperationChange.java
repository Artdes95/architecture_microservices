package archimicroservices.projet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class OperationChange {

    @Id
    private Long id;
    Long  idTauxChange;
    double amount;
    String date;
    String ccySrc;
    String ccyDest;
    double trnTaux;

    @Override
    public String toString() {
        return String.format(
                "Operation number : id=%d, %f '%s'/'%s'= %f ('%s')",
                id, amount, ccySrc, ccyDest, trnTaux, date);
    }
}
