package Google;

/**
 * Created by Zlatimir Ivanov on 8.1.2021 г..
 */

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed){
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        if (this.model.equals("")) return "";
        return String.format("%s %s%n",this.model, this.speed);
    }
}
