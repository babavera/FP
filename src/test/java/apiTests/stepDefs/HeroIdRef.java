package apiTests.stepDefs;

import apiTests.classes.CharacterGetRequest;
import apiTests.classes.Characters;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroIdRef {

    private final static String AUTHORIZATION = "?ts=1&apikey=07b0d846cafe9b5b9b8a341ee25876fa&hash=7754b05bf99ad4b66a62ab72e670ba34";

    List<Map<String, Integer>> heroesData;
    List<Characters> responseData;


    @Given("hero data known")
    public void heroDataKnown(DataTable dataTable) {
        heroesData = dataTable.asMaps(String.class,Integer.class);

    }

    @When("make a request for the service {string} by the name of the hero")
    public void makeARequestForTheServiceByTheNameOfTheHero(String string) {
        for (Map<String, Integer> heroesDatum : heroesData) {
            responseData.add((Characters) CharacterGetRequest
                    .getCharacter(string + heroesDatum.get("name")  + AUTHORIZATION));

        }

    }

    @Then("compare the result with the existing id")
    public void compareTheResultWithTheExistingId() {
        List<String> id = responseData.stream().map(Characters::getId).collect(Collectors.toList());
        for (int i = 0; i<responseData.size(); i++){
            System.out.println(heroesData.get(i).get("id"));
            System.out.println(id.get(i));
            //Assertions.assertEquals(toString(heroesData.get(i).get("id")), id.get(i));
        }

    }
}
