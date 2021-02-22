package TrafficLights;

/**
 * Created by Zlatimir Ivanov on 22.2.2021 г..
 */

public class TrafficLight {
    private String color;

//red green yellow
    public TrafficLight(String color){
        this.color = color;
    }

    public Lights nextLight(Lights light){
        if (light.ordinal() == 0){
            return Lights.GREEN;
        } else if (light.ordinal() == 1){
            return Lights.YELLOW;
        } else {
            return Lights.RED;
        }

    }
}
