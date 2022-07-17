package requests.user;

public class Phone {
    // создали поле для домашнего номера
    private String home;
    // создали поле для мобильного номера
    private String mobile;
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
}
