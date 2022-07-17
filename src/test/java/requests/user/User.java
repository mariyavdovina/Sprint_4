package requests.user;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class User {
    private int id;
    private Phone phone;
    // список групп, потому что в исходном JSON — массив элементов
    private List<Group> groups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    /*            User user = given()
                .header("Content-type", "application/json")
                .get("...")
                .body().as(User.class); */
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    @Test
    public void createNewPlaceAndCheckResponse(){
        User user =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmI5OWJlMWQzYjg2YTAwM2Q2N2M3ZmQiLCJpYXQiOjE2NjA5MDk1NjYsImV4cCI6MTY2MTUxNDM2Nn0.QoOikBPx81D3R6ZVfj42NQoahXtdCQz4N4Xcah00aEQ")
                        .get("/api/cards")
                        .body().as(User.class);
        MatcherAssert.assertThat(user, notNullValue());

    }

}