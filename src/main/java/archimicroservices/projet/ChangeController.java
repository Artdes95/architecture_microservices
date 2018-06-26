package archimicroservices.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private TauxChangeRepository repository;

    @GetMapping("/devise-change/source/{source}/dest/{dest}")
    public String retrouveTauxChange
            (@PathVariable String source, @PathVariable String dest){
        TauxChange tauxChange = repository.findBySourceAndDest(source, dest);
        tauxChange.affichage();
        return tauxChange.toString();
    }

    @GetMapping("/devise-change/add/{source}/{dest}/{taux}/{date}")
    public String ajoutTauxChange
            (@PathVariable String source, @PathVariable String dest, @PathVariable double taux, @PathVariable String date){
        TauxChange tauxChange = repository.save(new TauxChange(source,dest,taux,date));
        return tauxChange.toString();
    }

}
