package RawData;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Cargo {
    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType){
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }


}
