package SpeedRacing;

/**
 * Created by Zlatimir Ivanov on 2.1.2021 г..
 */

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPerKilometer;
    private int carTravel;

    public Car(String model, double fuelAmount, double fuelPerKilometer){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKilometer = fuelPerKilometer;
        this.carTravel = 0;
    }

    public boolean haveFuel(int distance){
        return distance * fuelPerKilometer <= fuelAmount;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.carTravel);
    }

    public void setCarTravel(int carTravel) {
        this.carTravel = carTravel;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelPerKilometer() {
        return fuelPerKilometer;
    }

    public int getCarTravel() {
        return carTravel;
    }
}
