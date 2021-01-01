package RawData;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public String getModel() {
        return model;
    }

    public Car(String model, Engine engine, Cargo cargo,Tire tire){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public String getCargo(){
        return this.cargo.getCargoType();
    }

    public boolean lessOne(){
        return this.tire.pressureLessOne();
    }

    public int power(){
        return this.engine.getEnginePower();
    }
}
