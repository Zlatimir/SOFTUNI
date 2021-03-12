package vehiclesExtension;

/**
 * Created by Zlatimir Ivanov on 10.3.2021 г..
 */

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double litersPerKilometer, double tankCapacity) {
        super(fuelQuantity, litersPerKilometer + FUEL_INCREASED_BUS, tankCapacity);
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
