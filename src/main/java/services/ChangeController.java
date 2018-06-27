package services;

import metier.TauxChange;
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

    @GetMapping("/devise-change/get/source/{source}/dest/{dest}")
    public String retrouveTauxChange
            (@PathVariable String source, @PathVariable String dest){
        List<TauxChange> tauxChange = repository.findBySourceAndDest(source, dest);
        return tauxChange.toString();
    }

    @GetMapping("/devise-change/create/{source}/{dest}/{date}/{taux}")
    public String ajoutTauxChange
            (@PathVariable String source, @PathVariable String dest,  @PathVariable String date, @PathVariable double taux){
        TauxChange tauxChange = repository.save(new TauxChange(source,dest,taux,date));
        return tauxChange.toString();
    }

    @GetMapping("/devise-change/modify/{source}/{dest}/{date}/{taux}")
    public int modifierTauxChange
            (@PathVariable String source, @PathVariable String dest, @PathVariable String date, @PathVariable double taux){
        int result = repository.update(source,dest,date,taux);
        return result;
    }

    @GetMapping("/devise-change/suppress/{source}/{dest}/{date}/{taux}")
    public void supprimerTauxChange
            (@PathVariable String source, @PathVariable String dest, @PathVariable String date, @PathVariable double taux){
            TauxChange tauxChange = repository.findBySourceAndDestAndDateAndTaux(source, dest, date, taux);
            repository.delete(tauxChange);
    }




}
