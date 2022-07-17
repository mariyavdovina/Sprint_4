package mocking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class ServiceClassTest {
/*
    @Test //аннотация, которая запускает тест
    public void test() throws IOException {
        ServiceClass serviceClass = new ServiceClass();
        Server server = new Server();
        int responseCode = serviceClass.sendGet("http://www.example.com/junk");
        System.out.println("Код ответа от сервера: " + responseCode);
        String status = server.checkServer(responseCode);
        Assert.assertEquals("Сервер доступен", status);
    }*/

    @Mock
    ServiceClass serviceClass;

/*    @Test
   public void test() throws IOException {
        Server server = new Server();
        *//* Вернётся код 200,
        ты имитируешь корректную работу нужного ресурса *//*
        Mockito.when(serviceClass.sendGet(Mockito.anyString())).thenReturn(200);
        int responseCode = serviceClass.sendGet("http://www.example.com/junk");
        System.out.println("Код ответа от сервера: " + responseCode);
        String status = server.checkServer(responseCode);
        Assert.assertEquals("Сервер доступен", status);
    }*/

    @Test
    public void test() throws IOException {
        Server server = new Server();

        Mockito.when(serviceClass.sendGet(Mockito.anyString())).thenReturn(400);
        int responseCode = serviceClass.sendGet("http://www.example.com");
        String status = server.checkServer(responseCode);
        Assert.assertEquals("Сервер недоступен", status);
    }

}
