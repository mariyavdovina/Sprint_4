package requests;
import io.restassured.RestAssured;
// импортируем Before
import io.restassured.response.Response;
import org.junit.Before;
// импортируем Test
import org.junit.Test;
// дополнительный статический импорт нужен, чтобы использовать given(), get() и then()
import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class PatchTest {


    @Before
    public void setUp() {
        // повторяющуюся для разных ручек часть URL лучше записать в переменную в методе Before
        // если в классе будет несколько тестов, указывать её придётся только один раз
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";

    }
    @Test
    public void updateProfileAndCheckStatusCode(){
        File json = new File("resources/updateProfile.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ")
                        .and()
                        .body(json)
                        .when()
                        .patch("/api/users/me");
        response.then().assertThat().body("data.name", equalTo("Василий Васильев"))
                .and()
                .statusCode(200);
    }

    @Test
    public void updateProfileAndCheckStatusCodeWithoutJson(){
        Profile profile = new Profile("Василий Васильев","Самый крутой исследователь");

        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ")
                        .and()
                        .body(profile)
                        .when()
                        .patch("/api/users/me");
        response.then().assertThat().body("data.name", equalTo("Василий Васильев"))
                .and()
                .statusCode(200);
    }

}
