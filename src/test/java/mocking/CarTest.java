package mocking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CarTest {
    @Mock
    Car car; // создали мок

    @Test
    public void test() {
        car.setCarBrand("Lamborghini"); // вызвали метод объекта с аргументом
        //Mockito.verify(car).setCarBrand("Lamborghini"); // проверили, что метод вызван с этим параметром
        Mockito.verify(car).setCarBrand("Lada");
    }
    @Test
    public void testTimes() {
        car.setCarBrand("Lamborghini");
        car.setCarBrand("Lamborghini");
        car.setCarBrand("Lamborghini"); // вызвали метод с одним аргументом три раза
        Mockito.verify(car, Mockito.times(3)).setCarBrand("Lamborghini");
        // проверили, что метод вызван три раза с этим аргументом
    }

    @Test
    public void testAny() {
        car.setCarBrand("Lamborghini"); // вызвали метод объекта с аргументом
        Mockito.verify(car).setCarBrand(Mockito.anyString());
        // проверили, что метод вызван с любой строкой в качестве аргумента
        Mockito.verify(car).setCarBrand(Mockito.any()); // тоже сработает: String - ссылочный тип данных
    }
}