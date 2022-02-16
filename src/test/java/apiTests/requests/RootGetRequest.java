package apiTests.requests;

import APITest.classes.Root;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class RootGetRequest {

    public static Root rootGetRequest(String URL1) {
        return given()
                .when().contentType(ContentType.JSON)
                .get(URL1).then().extract().as(Root.class);
    }
}
