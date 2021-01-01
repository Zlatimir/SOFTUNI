package Lab_CarInfo;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Car {
    private String make;
    private String model;
    private int horsePower;

    public Car(String make, String model, int horsePower){
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void carInfo(){
        System.out.printf("The car is: %s %s - %d HP.%n", this.getMake(), this.getModel(), this.getHorsePower());
    }
}
