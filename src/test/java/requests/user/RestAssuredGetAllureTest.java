package requests.user;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredGetAllureTest {

    String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ";

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    @DisplayName("Check status code of /users/me") // имя теста
    @Description("Basic test for /users/me endpoint") // описание теста
    public void getMyInfoStatusCode() {
        given()
                .auth().oauth2(bearerToken)
                .get("/api/users/me")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("Check user name") // имя теста
    @Description("Checking user name is very important") // описание теста
    public void checkUserName() {
        given()
                .auth().oauth2(bearerToken)
                .get("/api/users/me")
                .then().assertThat().body("data.name",equalTo("Василий Васильев"));
    }

    @Test
    @DisplayName("Check user name and print response body") // имя теста
    @Description("This is a more complicated test with console output")
    @TmsLink("TestCase-112") // ссылка на тест-кейс
    @Issue("BUG-985") // ссылка на баг-репорт
    public void checkUserNameAndPrintResponseBody() {

/*        Response response = given().auth().oauth2(bearerToken).get("/api/users/me");
        // отправили запрос и сохранили ответ в переменную response - экземпляр класса Response

        response.then().assertThat().body("data.name",equalTo("сюда впиши имя пользователя"));
        // проверили, что в теле ответа ключу name соответствует нужное имя пользователя

        System.out.println(response.body().asString()); // вывели тело ответа на экран*/
        Response response = sendGetRequestUsersMe();
        // отправили запрос и сохранили ответ в переменную response - экземпляр класса Response

        compareUserNameToText(response, "Василий Васильев");
        // проверили, что в теле ответа ключу name соответствует нужное имя пользователя

        printResponseBodyToConsole(response); // вывели тело ответа на экран
    }

    // метод для шага "Отправить запрос":
    @Step("Send GET request to /api/users/me")
    public Response sendGetRequestUsersMe(){
        Response response =given().auth().oauth2(bearerToken).get("/api/users/me");
        return response;
    }

    // метод для шага "Сравнить имя пользователя с заданным":
    @Step("Compare user name to something")
    public void compareUserNameToText(Response response, String username){
        response.then().assertThat().body("data.name",equalTo(username));
    }

    // метод для шага "Вывести тело ответа в консоль":
    @Step("Print response body to console")
    public void printResponseBodyToConsole(Response response){
        System.out.println(response.body().asString());
    }

}