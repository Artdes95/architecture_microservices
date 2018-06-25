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
    public TauxChange retrouveTauxChange
            (@PathVariable String source, @PathVariable String dest){
        TauxChange tauxChange = repository.findBySourceAndDest(source, dest);
        return tauxChange;
    } }