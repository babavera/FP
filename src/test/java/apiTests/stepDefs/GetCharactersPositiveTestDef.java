package apiTests.stepDefs;

import apiTests.requests.CharactersGetRequest;
import APITest.classes.Characters;
import APITest.classes.URLBuilder;
import apiTests.requests.RootGetRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import APITest.classes.Root;

public class GetCharactersPositiveTestDef {

    List<List<String>> heroesData;
    List<Characters> responseDataOfHeroes;
    Root responseRoot;
    List<String> responseNamesOfHeroes;
    List<String> responseIdOfHeroes;
    Map<String, String> map = new HashMap<>();

    @Given("We know information about superheroes")
    public void superheroesDataAdList(DataTable table) {
        heroesData = table.asLists(String.class);
        Assert.assertFalse(heroesData.isEmpty());
    }

    @When("We make a request for the service {string} to the heroes")
    public void requestForTheService(String URL) {
        responseDataOfHeroes = CharactersGetRequest.charactersGetRequest(URLBuilder.getURL(URL));
        responseRoot = RootGetRequest.rootGetRequest(URLBuilder.getURL(URL));
        Assert.assertFalse(responseDataOfHeroes.isEmpty());
        Assert.assertFalse(responseRoot.toString().isEmpty());
    }

    @And("Check status {string} and response code {string}")
    public void checkStatusAndResponseCode(String status, String code) {
        Assert.assertEquals(status, responseRoot.getStatus());
        Assert.assertEquals(code, responseRoot.getCode());
    }

    @And("Converting the received data")
    public void convertingData() {
        responseNamesOfHeroes = responseDataOfHeroes.stream().map(Characters::getName).collect(Collectors.toList());
        responseIdOfHeroes = responseDataOfHeroes.stream().map(Characters::getId).collect(Collectors.toList());
        for (int i = 0; i < responseDataOfHeroes.size(); i++) {
            map.put(responseNamesOfHeroes.get(i), responseIdOfHeroes.get(i));
        }
        Assert.assertFalse(map.isEmpty());
    }

    @Then("Compare the existing id and name with the received data")
    public void dataComparison() {
        for (List<String> heroesDatum : heroesData) {
            String heroesName = heroesDatum.get(0);
            Assert.assertTrue(responseNamesOfHeroes.contains(heroesName));
            String heroesId = heroesDatum.get(1);
            Assert.assertEquals(heroesId, map.get(heroesName));
        }
    }
}
