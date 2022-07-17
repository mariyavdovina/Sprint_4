package mocking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


   @RunWith(MockitoJUnitRunner.class)
public class Praktikum {

    @Mock
    Wheel wheel;

    @Test
    public void test() {
        Car car = new Car(wheel);
        Mockito.when(wheel.countWheels(2, 2)).thenReturn(5);
        /* Теперь стаб будет выводить 5, только если переданы аргументы 2 и 2.
        Иначе - 0 */
        System.out.println(car.getWheelsCount(2,2)); // выведется 5
        Mockito.when(wheel.countWheels(Mockito.anyInt(), Mockito.anyInt())).thenReturn(5);
        /* Теперь стаб выведет 5, если передать в него любое целое число.
        Иначе - 0 */
        System.out.println(car.getWheelsCount(2,2)); // выведется 5
        System.out.println(car.getWheelsCount(3,7)); // выведется 5
    }
}