package SpeedRacing;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 2.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");
            Car car = new Car(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
            cars.putIfAbsent(data[0], car);
        }

        String input = sc.nextLine();
        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            String model = data[1];
            int distance = Integer.parseInt(data[2]);

            if (cars.get(model).haveFuel(distance)){
                cars.get(model).setCarTravel(cars.get(model).getCarTravel() + distance);
                cars.get(model).setFuelAmount(cars.get(model).getFuelAmount() - distance * cars.get(model).getFuelPerKilometer());
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            input = sc.nextLine();
        }

        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }
}
