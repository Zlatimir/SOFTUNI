package vehicles;

/**
 * Created by Zlatimir Ivanov on 10.3.2021 г..
 */

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double litersPerKilometer) {
        super(fuelQuantity, litersPerKilometer + FUEL_INCREASED_TRUCK);
    }

    @Override
    protected void refuel(double liters) {
        this.fuelQuantity += liters * 0.95;
    }
}
