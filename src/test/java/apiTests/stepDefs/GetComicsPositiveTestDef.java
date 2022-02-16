package apiTests.stepDefs;

import APITest.classes.Comics;
import APITest.classes.Root;
import APITest.classes.URLBuilder;
import apiTests.requests.ComicsGetRequest;
import apiTests.requests.RootGetRequest;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.stream.Collectors;

public class GetComicsPositiveTestDef {

    List<Comics> responseDataOfComics;
    Root responseRoot;
    List<String> idComics;
    List<String> titleComics;
    List<String> pageCountComics;

    @Given("We make a request for the service {string} to the comics")
    public void requestForTheService(String URL) {
        responseDataOfComics = ComicsGetRequest.comicsRequest(URLBuilder.getURL(URL + "?"));
        responseRoot = RootGetRequest.rootGetRequest(URLBuilder.getURL(URL + "?"));
        Assertions.assertFalse(responseDataOfComics.isEmpty());
        Assertions.assertFalse(responseRoot.toString().isEmpty());
    }

    @Then("We check status {string}, response code {string} and number of comics {string} in response")
        public void checkStatusAndResponseCode(String status, String code, String numOfComics) {
        Assertions.assertEquals(status, responseRoot.getStatus());
        Assertions.assertEquals(code, responseRoot.getCode());
        Assertions.assertEquals(Integer.parseInt(numOfComics), responseDataOfComics.size());
    }

    @Then("check if response contains id, title and number of comic pages")
    public void checkResponse() {
        idComics = responseDataOfComics.stream().map(Comics::getId).collect(Collectors.toList());
        titleComics = responseDataOfComics.stream().map(Comics::getTitle).collect(Collectors.toList());
        pageCountComics = responseDataOfComics.stream().map(Comics::getPageCount).collect(Collectors.toList());
        Assertions.assertAll("Checking for data",
                () -> Assertions.assertFalse(idComics.isEmpty()),
                () -> Assertions.assertFalse(titleComics.isEmpty()),
                () -> Assertions.assertFalse(titleComics.isEmpty())
        );
    }
}
