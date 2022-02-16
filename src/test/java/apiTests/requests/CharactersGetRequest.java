package apiTests.requests;

import APITest.classes.Characters;
import io.restassured.http.ContentType;
import java.util.List;
import static io.restassured.RestAssured.given;

public class CharactersGetRequest {

    public static List<Characters> charactersGetRequest(String URL2) {
        return given()
                .when().contentType(ContentType.JSON)
                .get(URL2)
                .then().statusCode(200)
                .extract().jsonPath().getList("data.results", Characters.class);
    }
}

