package CarSalesman;

/**
 * Created by Zlatimir Ivanov on 2.1.2021 г..
 */

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power){
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s"
                , this.model, this.power, this.displacement, this.efficiency);
    }
}
