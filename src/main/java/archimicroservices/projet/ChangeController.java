package archimicroservices.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private TauxChangeRepository repository;

    @GetMapping("/devise-change/taux")
    public List<TauxChange> retrouveAll(){
        return repository.findAll();
    }

    @GetMapping("/devise-change/taux/{id}")
    public Optional<TauxChange> retrouveById(@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping("/devise-change/taux/{source}/{dest}")
    public List<TauxChange> retrouveTauxChange
            (@PathVariable String source, @PathVariable String dest){
        return repository.findBySourceAndDest(source, dest);
    }

    @GetMapping("/devise-change/taux/{source}/{dest}/{date}")
    public double retrouveTauxChangeDate
            (@PathVariable String source, @PathVariable String dest, @PathVariable String date){
        return repository.findBySourceAndDestAndDate(source, dest, date);
    }


    @PostMapping("/devise-change/taux/create")
    public TauxChange ajoutTauxChange
            (@RequestBody TauxChange tauxChange){
        return repository.save(tauxChange);
    }

    @PostMapping("/devise-change/taux/modify")
    public TauxChange modifierTauxChange
            (@RequestBody TauxChange tauxChange){
        return repository.save(tauxChange);
    }


    @PostMapping("/devise-change/taux/delete")
    public void supprimerTauxChange
            (@RequestBody TauxChange tauxChange){
            repository.delete(tauxChange);
    }




}
