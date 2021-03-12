package vehiclesExtension;

/**
 * Created by Zlatimir Ivanov on 10.3.2021 г..
 */

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double litersPerKilometer, double tankCapacity) {
        super(fuelQuantity, litersPerKilometer + FUEL_INCREASED_TRUCK, tankCapacity);
    }

    @Override
    protected void refuel(double liters) {
        if (this.fuelQuantity + liters * 0.95 > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters * 0.95;
        }
    }
}
