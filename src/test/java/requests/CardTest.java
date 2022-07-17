package requests;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CardTest {
    @Before
    public void setUp() {
        // повторяющуюся для разных ручек часть URL лучше записать в переменную в методе Before
        // если в классе будет несколько тестов, указывать её придётся только один раз
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }
    @Test
    public void createNewCard2() {
        for (int i = 0; i < 10; i++) {
            Card card = new Card(String.format("%s-%d", "Москва", i),
                    "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenium.jpg"); // экземпляр класса Card со значениями полей

            given()
                    .header("Content-type", "application/json") // передача Content-type в заголовке для указания типа файла
                    .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ") // передача токена для аутентификации
                    .and()
                    .body(card) // передача объекта с данными
                    .when()
                    .post("/api/cards") // отправка POST-запроса
                    .then().statusCode(201); // проверка кода ответа
        }
    }

    @Test
    public void likeTheFirstPhoto() {
        String oauthToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ";

        // получение списка фотографий и сохранение _id первой фотографии
        String photoId = given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .get("/api/cards") // отправка GET-запроса
                .then().extract().body().path("data[0]._id"); // получение ID фотографии из массива данных

        // лайк первой фотографии
        given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .put("/api/cards/{photoId}/likes", photoId) // отправка PUT-запроса
                .then().assertThat().statusCode(200); // проверка, что сервер вернул код 200

        // снять лайк с первой фотографии
        given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .delete("/api/cards/{photoId}/likes", photoId) // отправка DELETE-запроса
                .then().assertThat().statusCode(200); // проверка, что сервер вернул код 200
    }
}
