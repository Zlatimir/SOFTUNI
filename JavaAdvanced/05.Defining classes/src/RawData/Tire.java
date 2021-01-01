package RawData;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Tire {
    private double tire1Pressure;
    private double tire2Pressure;
    private double tire3Pressure;
    private double tire4Pressure;
    private int tire1Age;
    private int tire2Age;
    private int tire3Age;
    private int tire4Age;

    public Tire(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age
                , double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age){
        this.tire1Pressure = tire1Pressure;
        this.tire2Pressure = tire2Pressure;
        this.tire3Pressure = tire3Pressure;
        this.tire4Pressure = tire4Pressure;
        this.tire1Age = tire1Age;
        this.tire2Age = tire2Age;
        this.tire3Age = tire3Age;
        this.tire4Age = tire4Age;
    }

    public double getTire1Pressure() {
        return tire1Pressure;
    }

    public double getTire2Pressure() {
        return tire2Pressure;
    }

    public double getTire3Pressure() {
        return tire3Pressure;
    }

    public double getTire4Pressure() {
        return tire4Pressure;
    }

    public boolean pressureLessOne(){
        return tire1Pressure < 1 || tire2Pressure < 1 || tire3Pressure < 1 || tire4Pressure < 1;
    }
}
