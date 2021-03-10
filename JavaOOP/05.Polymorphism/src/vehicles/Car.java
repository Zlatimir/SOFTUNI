package vehicles;

/**
 * Created by Zlatimir Ivanov on 10.3.2021 г..
 */

public class Car extends Vehicle {

    public Car(double fuelQuantity, double litersPerKilometer) {
        super(fuelQuantity, litersPerKilometer + FUEL_INCREASED_CAR);
    }

    @Override
    protected void refuel(double liters) {
        this.fuelQuantity += liters;
    }


}
