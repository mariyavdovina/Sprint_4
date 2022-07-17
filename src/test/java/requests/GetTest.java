package requests;


    // импортируем RestAssured
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

public class GetTest {

        // аннотация Before показывает, что метод будет выполняться перед каждым тестовым методом
        @Before
        public void setUp() {
            // повторяющуюся для разных ручек часть URL лучше записать в переменную в методе Before
            // если в классе будет несколько тестов, указывать её придётся только один раз
            RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
        }

        // создаём метод автотеста
        @Test
        public void getMyInfoStatusCode() {
            // метод given() помогает сформировать запрос
            given()
                    // указываем протокол и данные авторизации
                    .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ")
                    // отправляем GET-запрос с помощью метода get, недостающую часть URL (ручку) передаём в него в качестве параметра
                    .get("/api/users/me")
                    // проверяем, что статус-код ответа равен 200
                    //.then().statusCode(200);
                    .then().assertThat().body("data.name", equalTo("Жак-Ив Кусто  The Greate"));
        }

    @Test
    public void checkUserNameAndPrintResponseBody() {

        // отправляет запрос и сохраняет ответ в переменную response, экзмепляр класса Response
        Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ").get("/api/users/me");
        // проверяет, что в теле ответа ключу name соответствует нужное имя пользователя
        response.then().assertThat().body("data.name",equalTo("Жак-Ив Кусто  The Greate"));
        // выводит тело ответа на экран
        System.out.println(response.body().asString());

    }
    @Test
    public void postNewJson(){
        File json = new File("src/test/java/resources/newCard.json");
        given()
                .header("Content-type", "application/json")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ")
                .and()
                .body(json)
                .when()
                .post("/api/cards")
                .then().statusCode(201);
    }
    @Test
    public void createNewPlaceAndCheckResponse(){
        File json = new File("src/test/java/resources/newCard.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ")
                        .and()
                        .body(json)
                        .when()
                        .post("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }


    @Test
    public void createNewPlaceAndCheckResponseAsString(){
        String json = "{\"name\": \"Очень интересное место\", \"link\": \"https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg\"}";;
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ")
                        .and()
                        .body(json)
                        .when()
                        .post("/api/cards"); //.patch("/api/cards"); - the same via patch - method
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }
    }

    /*eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ*/

