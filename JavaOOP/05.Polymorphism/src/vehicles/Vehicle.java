package vehicles;

/**
 * Created by Zlatimir Ivanov on 10.3.2021 г..
 */

public abstract class Vehicle {
    public static final double FUEL_INCREASED_CAR = 0.9;
    public static final double FUEL_INCREASED_TRUCK = 1.6;

    protected double fuelQuantity;
    protected double litersPerKilometer;
    protected double traveledDistance;


    public Vehicle(double fuelQuantity, double litersPerKilometer) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKilometer = litersPerKilometer;
    }

    protected boolean drive(double distance) {
        double fuelNeeded = distance * this.litersPerKilometer;
        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;
            this.traveledDistance += distance;
            return true;
        }
        return false;
    }

    protected abstract void refuel(double liters);
}
