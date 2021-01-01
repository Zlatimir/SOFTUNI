package Lab_Constructors;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Car1 {
    private String make;
    private String model;
    private int horsePower;

    public Car1(String make, String model, int horsePower){
        this(make);
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car1(String make){
        this.make = make;
        this.model = "unknown";
        this.horsePower = -1;
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
