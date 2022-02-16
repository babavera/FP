package apiTests.requests;

import APITest.classes.Comics;
import io.restassured.http.ContentType;
import java.util.List;
import static io.restassured.RestAssured.given;

public class ComicsGetRequest {

    public static List<Comics> comicsRequest(String URL2) {
        return given()
                .when().contentType(ContentType.JSON)
                .get(URL2)
                .then().extract().jsonPath()
                .getList("data.results", Comics.class);
    }


}
