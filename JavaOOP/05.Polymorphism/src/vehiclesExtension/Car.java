package vehiclesExtension;

/**
 * Created by Zlatimir Ivanov on 10.3.2021 г..
 */

public class Car extends Vehicle {

    public Car(double fuelQuantity, double litersPerKilometer, double tankCapacity) {
        super(fuelQuantity, litersPerKilometer + FUEL_INCREASED_CAR, tankCapacity);
    }

    @Override
    protected void refuel(double liters) {
        if (this.fuelQuantity + liters > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }


}
