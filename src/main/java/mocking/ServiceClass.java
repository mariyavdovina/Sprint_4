package mocking;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceClass {

    public int sendGet(String requestUrl) throws IOException {
        /*
        Строка преобразуется в объект URL. Его используют, чтобы установить
        http/https соединение с удалённым сервером */
        URL url = new URL(requestUrl);
        // Открывается соединение между программой и удалённым сервером
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        /* http-метод отпраляется на сервер
        GET запрашивает информацию */
        connection.setRequestMethod("GET");
        // Приходит код ответа от сервера
        return connection.getResponseCode();
    }

}
