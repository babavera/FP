package apiTests.classes;

import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CharacterGetRequest {

    public static List<Characters>  getCharacter(String str) {

        return given()
                .when().contentType(ContentType.JSON)
                .get(str)
                .then().extract().jsonPath().getList("data.results", Characters.class);
    }
}

