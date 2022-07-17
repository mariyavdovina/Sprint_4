package mocking;

public class Server {

    public String checkServer(int responseCode) {
        if (200 == responseCode) {
            return "Сервер доступен";
        } else {
            return "Сервер недоступен";
        }
    }

}
