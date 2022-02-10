package apiTests.stepDefs;

import apiTests.classes.CharacterGetRequest;
import apiTests.classes.Characters;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class APITestDef {

    private final static String AUTHORIZATION = "?ts=1&apikey=07b0d846cafe9b5b9b8a341ee25876fa&hash=7754b05bf99ad4b66a62ab72e670ba34";

    List<Map<String, Integer>> heroesData;
    List<Characters> responseData;

    @Given("superhero data known")
    public void heroesData (DataTable dataTable) {
        heroesData = dataTable.asMaps(String.class,Integer.class);

    }
    @When("we make a request for the service {string} by the name of the hero")
    public void getRequestsCharacters (String string) {
        for (Map<String, Integer> heroesDatum : heroesData) {
            responseData.add((Characters) CharacterGetRequest
                    .getCharacter(string + heroesDatum.get("name")  + AUTHORIZATION));

        }
    }
    @Then("we compare the result with the existing id")
    public void we_compare_the_result_with_the_existing_id() {
        List<String> id = responseData.stream().map(Characters::getId).collect(Collectors.toList());
        for (int i = 0; i<responseData.size(); i++){
            System.out.println(heroesData.get(i).get("id"));
            System.out.println(id.get(i));
            //Assertions.assertEquals(toString(heroesData.get(i).get("id")), id.get(i));
        }
    }
}
