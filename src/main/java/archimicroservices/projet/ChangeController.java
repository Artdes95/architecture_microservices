package archimicroservices.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private TauxChangeRepository repository;

    @GetMapping("/devise-change/taux/get/{source}/{dest}")
    public String retrouveTauxChange
            (@PathVariable String source, @PathVariable String dest){
        List<TauxChange> tauxChange = repository.findBySourceAndDest(source, dest);
        if (!tauxChange.isEmpty())return tauxChange.toString();
        else return "Doesn't exist";

    }

    @GetMapping("/devise-change/taux/create/{source}/{dest}/{date}/{taux}")
    public String ajoutTauxChange
            (@PathVariable String source, @PathVariable String dest,  @PathVariable String date, @PathVariable double taux){
        TauxChange tauxChange = repository.save(new TauxChange(source,dest,taux,date));
        if(!tauxChange.equals(null))return tauxChange.toString();
        else return "Creation Failed";
    }

    @GetMapping("/devise-change/taux/modify/{source}/{dest}/{date}/{taux}")
    public String modifierTauxChange
            (@PathVariable String source, @PathVariable String dest, @PathVariable String date, @PathVariable double taux){
        int result = repository.update(source,dest,date,taux);
        if(result==1){
            return retrouveTauxChange(source,dest);
        }
        else return "Modification Failed";
    }


    @GetMapping("/devise-change/taux/suppress/{source}/{dest}/{date}/{taux}")
    public String supprimerTauxChange
            (@PathVariable String source, @PathVariable String dest, @PathVariable String date, @PathVariable double taux){
            TauxChange tauxChange = repository.findBySourceAndDestAndDateAndTaux(source, dest, date, taux);
            if(!tauxChange.equals(null)) {repository.delete(tauxChange);return "Suppression successful";}
            else return "Suppression failed";
    }




}
