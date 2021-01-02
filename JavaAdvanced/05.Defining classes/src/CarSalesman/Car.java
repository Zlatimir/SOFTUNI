package CarSalesman;

/**
 * Created by Zlatimir Ivanov on 2.1.2021 г..
 */

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s%nWeight: %s%nColor: %s", this.model, this.engine, this.weight, this.color);
    }
}
