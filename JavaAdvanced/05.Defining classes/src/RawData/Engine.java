package RawData;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower){
        this.enginePower = enginePower;
        this.engineSpeed = engineSpeed;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}
