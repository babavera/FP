package apiTests.stepDefs;

import APITest.classes.Root;
import APITest.classes.URLBuilder;
import apiTests.requests.RootGetRequest;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class GetCharactersNegativeTest {

    String URL;
    Root responseRoot;

    @Given("we have a resource {string}")
    public void haveAResource(String URL) {
        this.URL = URL;
    }

    @When("we make a request with incorrect parameters {string} and value {string}")
    public void makeARequestWithIncorrectParameters(String param, String val) {
        responseRoot = RootGetRequest.rootGetRequest(URLBuilder.getURL(URL + param + "=" + val + "&"));
    }

    @Then("we should get a response with a code and status")
    public void getAResponseWithACodeAndStatus() {
        Assertions.assertFalse(responseRoot.getCode().isEmpty());
        Assertions.assertFalse(responseRoot.getStatus().isEmpty());
    }

    @And("compare the received data with existing ones {string} and {string}")
    public void compareWithExistingCodeAndStatus(String code, String status) {
        Assertions.assertEquals(code, responseRoot.getCode());
        Assertions.assertEquals(status, responseRoot.getStatus());
    }
}
