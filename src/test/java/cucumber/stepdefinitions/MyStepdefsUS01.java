package cucumber.stepdefinitions;

import archimicroservices.projet.TauxChange;
import archimicroservices.projet.TauxChangeRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefsUS01 {
    TauxChangeRepository repository;
    TauxChange tauxChange;

    @Given("^creation d'un taux de change$")
    public void creationDUnTauxDeChange() throws Throwable {
        tauxChange = new TauxChange("EUR","USD",1.12 ,"20180624");
    }

    @When("^taux devient persistant$")
    public void tauxDevientPersistant() throws Throwable {
        repository.save(tauxChange);
    }

    @Then("^le taux es bien dans la base$")
    public void leTauxEsBienDansLaBase() throws Throwable {
        assert repository.findBySourceAndDest("EUR","USD")==tauxChange;

    }
}

