package carTrip;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelNull() {
        String model = null;
        Car car = new Car(model, 50, 25, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelEmpty() {
        String model = " ";
        Car car = new Car(model, 50, 25, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountGreaterThenTankCapacity() {
        Car car = new Car("Lada", 50, 100, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionPerKmLessZero() {
        Car car = new Car("Lada", 50, 25, -5);
    }

    @Test(expected = IllegalStateException.class)
    public void testDriveVeryLongDistance() {
        Car car = new Car("Lada", 50, 10, 2);
        car.drive(50);
    }

    @Test
    public void testDriveEnoughFuel() {
        Car car = new Car("Lada", 50, 50, 1);
        String result = car.drive(5);
        Assert.assertEquals("Have a nice trip", result);
    }

    @Test(expected = IllegalStateException.class)
    public void testRefuelMoreThanTankCapacity() {
        Car car = new Car("Lada", 10, 5, 1);
        car.refuel(25);
    }

    @Test
    public void testFuelAmount() {
        Car car = new Car("Lada", 10, 2, 1);
        double fuel = car.getFuelAmount();
        assertEquals(2, fuel, 0);
    }

    @Test
    public void testTankCapacity() {
        Car car = new Car("Lada", 100, 25, 1);
        double capacity = car.getTankCapacity();
        assertEquals(100, capacity, 0);
    }


}