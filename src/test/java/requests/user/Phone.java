package requests.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Phone {
    // создали поле для домашнего номера
    private String home;
    // создали поле для мобильного номера
    private String mobile;

    public Phone(String home, String mobile) {
        this.home = home;
        this.mobile = mobile;
    }

    // добавили геттеры и сеттеры для доступа к данным
    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public static void main(String[] args) {
        Gson gson = new Gson();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Phone phone = new Phone("+79213389556","+79213389556");
        String json = gson.toJson(phone);
        System.out.println(json);
        String jsonString = "{\"home\":\"+79213389556\",\"mobile\":\"+79213389556\"}";
        Phone phoneNew = gson.fromJson(jsonString, Phone.class);
        System.out.println(phoneNew.home);
    }

}
