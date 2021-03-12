package vehiclesExtension;

/**
 * Created by Zlatimir Ivanov on 10.3.2021 г..
 */

public abstract class Vehicle {
    public static final double FUEL_INCREASED_CAR = 0.9;
    public static final double FUEL_INCREASED_TRUCK = 1.6;
    public static final double FUEL_INCREASED_BUS = 1.4;

    protected double fuelQuantity;
    protected double litersPerKilometer;
    protected double traveledDistance;
    protected double tankCapacity;


    public Vehicle(double initialFuelQuantity, double litersPerKilometer, double tankCapacity) {
        this.setFuelQuantity(initialFuelQuantity);
        this.setLitersPerKilometer(litersPerKilometer);
        this.setTankCapacity(tankCapacity);
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity > 0) {
            this.fuelQuantity = fuelQuantity;
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    private void setLitersPerKilometer(double litersPerKilometer) {
        if (litersPerKilometer < 0) {
            litersPerKilometer = 0;
        }
        this.litersPerKilometer = litersPerKilometer;
    }

    private void setTankCapacity(double tankCapacity) {
        if (tankCapacity < 0) {
            tankCapacity = 0;
        }
        this.tankCapacity = tankCapacity;
    }

    protected boolean drive(double distance) {
        double fuelNeeded = distance * this.litersPerKilometer;
        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;
            //this.traveledDistance += distance;
            return true;
        }
        return false;
    }

    protected abstract void refuel(double liters);
}
