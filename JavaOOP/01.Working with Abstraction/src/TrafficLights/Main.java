package TrafficLights;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 22.2.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//red green yellow
        String[] input = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sc.nextLine());

        TrafficLight light;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < input.length; j++) {
                String color = input[j];

                light = new TrafficLight(color);
                System.out.print(light.nextLight(Lights.valueOf(color)) + " ");
                input[j] = light.nextLight(Lights.valueOf(color)).toString();
            }
            System.out.println();
        }
    }
}
