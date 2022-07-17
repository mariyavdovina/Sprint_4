package mocking;

public class Car {

    private String carBrand;
    Wheel wheel;

    public Car(Wheel wheel) {
        this.wheel = wheel;
    }

    public int getWheelsCount(int frontWheels, int backWheels) {
        return wheel.countWheels(frontWheels, backWheels);
    }
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

}
